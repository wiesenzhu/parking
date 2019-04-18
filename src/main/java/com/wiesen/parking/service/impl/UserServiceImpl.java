package com.wiesen.parking.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wiesen.parking.entity.Community;
import com.wiesen.parking.entity.ManageUser;
import com.wiesen.parking.exception.RestException;
import com.wiesen.parking.mapper.CommunityMapper;
import com.wiesen.parking.mapper.ManageUserMapper;
import com.wiesen.parking.service.UserService;
import com.wiesen.parking.vo.LoginVO;
import com.wiesen.parking.vo.RegisterVO;
import com.wiesen.parking.vo.Response;
import com.wiesen.parking.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ManageUserMapper manageUserMapper;
    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public UserVO validLoginInfo(LoginVO vo) {
        ManageUser mu = new ManageUser();
        mu.setMobile(vo.getMobile());
        mu.setPassword(vo.getPassword());
        mu = manageUserMapper.selectOne(new QueryWrapper<>(mu));
        if (null != mu) {/* 用户名密码正确, 查询小区信息*/
            UserVO userVO = new UserVO();
            userVO.setRealName(mu.getRealName());
            userVO.setMobile(mu.getMobile());
            userVO.setUserId(mu.getId());
            Community community = communityMapper.selectById(mu.getCommunityId());
            if (null != community) {
                userVO.setCommunityId(community.getId());
                userVO.setCommunityName(community.getName());
            }
            return userVO;
        }
        return null;
    }

    @Override
    public UserVO getUserInfo(Long userId) {
        UserVO userVO = new UserVO();
        ManageUser mu = manageUserMapper.selectById(userId);
        Assert.notNull(mu, "用户信息不存在");/* 用户名密码正确, 查询小区信息*/
        userVO.setRealName(mu.getRealName());
        userVO.setMobile(mu.getMobile());
        Community community = communityMapper.selectById(mu.getCommunityId());
        Assert.notNull(community, "没有归属小区");
        userVO.setCommunityName(community.getName());
        return userVO;
    }

    @Override
    public void mUserRegister(RegisterVO vo) {/* 1. 判断手机号是否已经注册*/
        Map<String, Object> param = new HashMap<>();
        param.put("mobile", vo.getMobile());
        List<ManageUser> manageUsers = manageUserMapper.selectByMap(param);
        if (!CollectionUtils.isEmpty(manageUsers))
            throw new RestException("该手号已被注册", Response.REG_FAIL);/* 2. 注册*/
        ManageUser mu = new ManageUser();
        BeanUtils.copyProperties(vo, mu);
        manageUserMapper.insert(mu);
    }
}