package com.granvilledon.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.granvilledon.grapicommon.model.entity.UserInterfaceInfo;
import com.granvilledon.project.common.ErrorCode;
import com.granvilledon.project.exception.BusinessException;
import com.granvilledon.project.mapper.UserInterfaceInfoMapper;
import com.granvilledon.project.service.UserInterfaceInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author tangu
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service实现
* @createDate 2025-03-10 15:40:21
*/
@Service
@Slf4j
public class UserInterfaceInfoServiceImpl extends ServiceImpl<UserInterfaceInfoMapper, UserInterfaceInfo>
        implements UserInterfaceInfoService{

    @Override
    public void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add) {
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        // 创建时，所有参数必须非空
        if (add) {
            if (userInterfaceInfo.getInterfaceInfoId() <= 0 || userInterfaceInfo.getUserId() <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "接口或用户不存在");
            }
        }
        if (userInterfaceInfo.getLeftNum() < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "剩余次数不能小于 0");
        }
    }

    // [编程学习交流圈](https://www.code-nav.cn/) 快速入门编程不走弯路！30+ 原创学习路线和专栏、500+ 编程学习指南、1000+ 编程精华文章、20T+ 编程资源汇总

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        // 判断
        if (interfaceInfoId <= 0 || userId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UpdateWrapper<UserInterfaceInfo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("interfaceInfoId", interfaceInfoId);
        updateWrapper.eq("userId", userId);

//        updateWrapper.gt("leftNum", 0);
        updateWrapper.setSql("leftNum = leftNum - 1, totalNum = totalNum + 1");
        return this.update(updateWrapper);
    }

    @Override
    public int getLeftNum(long interfaceInfoId, long userId) {
        if (userId <= 0 || interfaceInfoId <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        UserInterfaceInfo userInterfaceInfo = this.getOne(new QueryWrapper<UserInterfaceInfo>()
                .eq("userId", userId)
                .eq("interfaceInfoId", interfaceInfoId));
//        log.info("查询用户接口记录：userId={}, interfaceInfoId={}", userId, interfaceInfoId);
        // 判空处理
        if (userInterfaceInfo == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "用户接口记录不存在");
        }
        return userInterfaceInfo.getLeftNum();
    }
}



