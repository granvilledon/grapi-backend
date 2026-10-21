package com.granvilledon.grapicommon.service;

/**
 * 内部用户接口统计服务（供 Dubbo 网关侧调用的内部接口，不对外暴露）
 */
public interface InnerUserInterfaceInfoService {

    /**
     * 接口调用次数 +1（leftNum 原子扣减，余额为 0 时拒绝）
     *
     * @param interfaceInfoId 接口 id
     * @param userId          调用用户 id
     * @return 是否扣减成功
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 查询用户对某接口的剩余调用次数
     *
     * @param interfaceInfoId 接口 id
     * @param userId          调用用户 id
     * @return 剩余次数
     */
    int getLeftNum(long interfaceInfoId, long userId);
}
