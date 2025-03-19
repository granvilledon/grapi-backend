package com.granvilledon.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.granvilledon.grapicommon.model.entity.UserInterfaceInfo;

/**
* @author tangu
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-03-10 15:40:21
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {

    // [编程导航学习圈](https://t.zsxq.com/0emozsIJh) 连接万名编程爱好者，一起优秀！20000+ 小伙伴交流分享、40+ 大厂嘉宾一对一答疑、4000+ 编程问答参考、100+ 各方向编程交流群

    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 获取是否还有剩余调用次数
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    int getLeftNum(long interfaceInfoId, long userId);
}
