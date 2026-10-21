package com.granvilledon.grapicommon.service;

import com.granvilledon.grapicommon.model.entity.User;

/**
 * 内部用户服务（供 Dubbo 网关侧调用的内部接口，不对外暴露）
 */
public interface InnerUserService {

    /**
     * 根据 accessKey 获取调用方用户信息
     *
     * @param accessKey 调用方公钥
     * @return 用户信息，不存在时返回 null
     */
    User getInvokeUser(String accessKey);
}
