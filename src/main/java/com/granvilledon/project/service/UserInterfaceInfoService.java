package com.granvilledon.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.granvilledon.project.model.entity.InterfaceInfo;
import com.granvilledon.project.model.entity.UserInterfaceInfo;

/**
* @author tangu
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2025-03-10 15:40:21
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    public void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add);

    /**
     * 调用次数
     * @return
     */
    boolean invokeCount(Long interfaceInfoId, long userId);
}
