# grapi-frontend · API 开放平台管理端前端

`grapi-backend`（API 开放平台）的管理端前端，基于 Ant Design Pro 5.x / Umi 4 脚手架开发。

## 已实现页面

| 路由 | 页面 | 说明 |
|---|---|---|
| `/user/login` | 登录 | 对接后端 `POST /api/user/login`（Session Cookie） |
| `/list` | 接口管理 | 接口分页查询 / 新建 / 修改 / 删除，全部对接真实后端接口 |
| `/welcome` | 欢迎页 | 展示当前登录用户信息 |
| `/admin` | 管理页 | 仅 admin 角色可见（`access.ts`） |

请求层：`src/requestConfig.ts` 统一配置 baseURL 与凭证（`withCredentials`），业务服务位于 `src/services/grapi-backend/`。

## 本地开发

```bash
# 1. 先启动后端 grapi-service（默认 http://localhost:7529）
# 2. 安装依赖并启动（推荐 pnpm）
pnpm install
pnpm dev
# 默认地址 http://localhost:8000
```

> 提示：`src/requestConfig.ts` 中 baseURL 默认为 `http://localhost:7529`，与后端联调无需代理。
