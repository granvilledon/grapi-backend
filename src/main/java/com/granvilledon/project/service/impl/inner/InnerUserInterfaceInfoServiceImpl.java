package com.granvilledon.project.service.impl.inner;


import com.granvilledon.grapicommon.service.InnerUserInterfaceInfoService;
import com.granvilledon.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * 内部用户接口信息服务实现类
 *
 * @author <a href="https://github.com/ligranvilledon">程序员鱼皮</a>
 * @from <a href="https://granvilledon.icu">编程导航知识星球</a>
 */
@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }
    @Override
    public int getLeftNum(long interfaceInfoId, long userId) {
        if (userInterfaceInfoService == null) {
            throw new IllegalStateException("userInterfaceInfoService is not injected");
        }
        return userInterfaceInfoService.getLeftNum(interfaceInfoId, userId);
    }
}
