package com.granvilledon.project.service.impl;

import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.granvilledon.project.common.ErrorCode;
import com.granvilledon.project.exception.BusinessException;
import com.granvilledon.project.model.entity.InterfaceInfo;
import com.granvilledon.project.model.enums.PostGenderEnum;
import com.granvilledon.project.model.enums.PostReviewStatusEnum;
import com.granvilledon.project.service.InterfaceInfoService;
import com.granvilledon.project.mapper.InterfaceInfoMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author tangu
 * @description 针对表【interface_info(接口信息)】的数据库操作Service实现
 * @createDate 2025-03-05 19:11:25
 */
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
        implements InterfaceInfoService {
    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Long id = interfaceInfo.getId();
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }
    }
}




