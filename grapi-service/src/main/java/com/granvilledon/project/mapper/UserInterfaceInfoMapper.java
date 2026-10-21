package com.granvilledon.project.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.granvilledon.grapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
* @author tangu
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Mapper
* @createDate 2025-03-10 15:40:21
* @Entity com.granvilledon.project.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);
}




