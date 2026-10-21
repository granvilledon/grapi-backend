# grapi-backend · API 开放平台

一个提供 API 接口供开发者调用的平台：管理员可以接入并发布接口、统计各接口调用情况；用户可以注册登录、开通接口调用权限、在线调试接口，并通过客户端 SDK 在自己的代码里签名调用。

> 说明：本项目基于鱼皮（编程导航）的「API 开放平台」课程学习开发，在其架构与业务流程的基础上完成了工程化整理与问题修复（见下文[相对课程的改进](#相对课程的改进)）。

## 模块结构

```
grapi-backend（聚合工程，Maven 多模块）
├── grapi-common        公共模块：跨服务共享的实体（User / InterfaceInfo / UserInterfaceInfo）
│                       与内部 Dubbo 服务接口（Inner*Service）
├── grapi-client-sdk    客户端 SDK（Spring Boot Starter）：请求签名 + HTTP 调用封装，
│                       使用方只需配置 access-key / secret-key 即可注入 GrapiClient
├── grapi-service       主服务：用户 / 接口管理 / 调用统计 / 在线调试，
│                       Dubbo provider（Nacos 注册中心），供网关通过 RPC 调用
└── grapi-frontend      管理端前端（React 18 + Ant Design Pro 5.x / Umi 4）：
                        登录 + 接口管理（增删改查 / 分页），对接真实后端接口
```

## 技术栈

| 层面 | 技术 |
|---|---|
| 框架 | Java 8 · Spring Boot 2.7 · MyBatis-Plus 3.5 |
| RPC | Dubbo 3 + Nacos 注册中心（分布式改造：网关与服务解耦） |
| 存储 | MySQL + Redis（Session 共享） |
| 文档 | Knife4j（Swagger） |
| 认证 | Session 登录 + API 签名认证（SHA-256 摘要） |

## 调用链路

```
开发者代码
   │  GrapiClient（SDK：参数 + ak/sk 签名）
   ▼
（网关层，见下文已知限制）
   │  校验签名 → 扣减调用次数 → Dubbo 泛化调用
   ▼
grapi-service ──── MySQL（user / interface_info / user_interface_info）
```

签名算法：`sign = SHA256(body + "." + secretKey)`，请求头携带 `accessKey / sign / body`，服务端按 accessKey 查出 secretKey 重新计算并比对。SDK 侧实现见 `grapi-client-sdk/src/.../utils/SignUtils.java`。

## 快速开始

```bash
# 1. 准备环境：JDK 8、Maven 3.8+、MySQL、Redis、Nacos（2.x）
# 2. 建库建表
mysql < grapi-service/sql/ddl.sql

# 3. 配置环境变量（口令不落盘）
export DB_PASSWORD=你的数据库口令
export GRAPI_ACCESS_KEY=xxx     # 测试用调用方凭证
export GRAPI_SECRET_KEY=yyy
# 可选：NACOS_ADDR（默认 localhost:8848）

# 4. 构建并启动主服务
mvn -B package
java -jar grapi-service/target/grapi-service.jar
# 服务起在 http://localhost:7529/api，接口文档 /api/doc.html

# 5. 启动管理端前端（详见 grapi-frontend/README.md）
cd grapi-frontend && pnpm install && pnpm dev
# 默认地址 http://localhost:8000，登录后即可管理接口

# 6. SDK 使用（其他 Spring Boot 项目引入 grapi-client-sdk 后）
# application.yml:
#   grapi:
#     client:
#       access-key: xxx
#       secret-key: yyy
```

## 相对课程的改进

- **修复调用次数超扣缺陷**：`invokeCount` 原实现把 `leftNum > 0` 的守卫注释掉了，并发下余额会扣成负数；已恢复为带条件的原子扣减（`UPDATE ... WHERE leftNum > 0`）。
- **工程自包含**：原仓库依赖一个不在仓库里的 `grapi-common` 外部 jar、且 `grapi-client-sdk` 是一个没有 `.gitmodules` 的坏 submodule（clone 下来是空目录），clone 后无法编译。现重构为 Maven 多模块聚合工程，`git clone` + `mvn package` 即可构建。
- **密钥全部外置**：数据库口令、调用方 ak/sk 改为环境变量注入，不再提交到仓库。
- **清理教程残留**：删除未使用的 Post 系列 DTO/枚举、课程推广注释、错误的外链，SQL 演示数据不再入库。

## 已知限制

- 网关模块（Spring Cloud Gateway 统一鉴权与计费）暂未收录进本仓库，前端管理页直连主服务；调用统计与接口分析页面未实现。
- 前端目前完成登录与接口管理页，"在线调试"等页面待开发。
- 签名为基础版（无时间戳/nonce），防重放需在网关层补充。
