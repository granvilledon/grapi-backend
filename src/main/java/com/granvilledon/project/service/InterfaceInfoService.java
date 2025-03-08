package com.granvilledon.project.service;

import com.granvilledon.project.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author tangu
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2025-03-05 19:11:25
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
