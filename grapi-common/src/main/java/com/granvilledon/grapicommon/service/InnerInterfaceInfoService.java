package com.granvilledon.grapicommon.service;

import com.granvilledon.grapicommon.model.entity.InterfaceInfo;

/**
 * 内部接口信息服务（供 Dubbo 网关侧调用的内部接口，不对外暴露）
 */
public interface InnerInterfaceInfoService {

    /**
     * 根据请求路径与方法获取接口信息
     *
     * @param url    接口相对路径
     * @param method 请求方法（GET / POST）
     * @return 接口信息，不存在时返回 null
     */
    InterfaceInfo getInterfaceInfo(String url, String method);
}
