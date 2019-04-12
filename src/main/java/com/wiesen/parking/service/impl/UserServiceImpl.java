package com.wiesen.parking.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wiesen.parking.entity.Community;
import com.wiesen.parking.entity.ManageUser;
import com.wiesen.parking.mapper.CommunityMapper;
import com.wiesen.parking.mapper.ManageUserMapper;
import com.wiesen.parking.service.UserService;
import com.wiesen.parking.vo.LoginVO;
import com.wiesen.parking.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public Long validLoginInfo(LoginVO vo) {
        ManageUser mu = new ManageUser();
        mu.setMobile(vo.getMobile());
        mu.setPassword(vo.getPassword());
        mu = manageUserMapper.selectOne(new QueryWrapper<>(mu));
        if (null != mu) {
//            // 用户名密码正确, 查询小区信息
//            UserVO userVO = new UserVO();
//            userVO.setRealName(mu.getRealName());
//            userVO.setMobile(mu.getMobile());
//            Community community = communityMapper.selectById(mu.getCommunityId());
//            if (null != community) {
//                userVO.setCommunityName(community.getName());
//            }
            return mu.getId();
        }
        return null;
    }

    @Override
    public UserVO getUserInfo(Long userId) {
        UserVO userVO = new UserVO();

        ManageUser mu = manageUserMapper.selectById(userId);
        Assert.notNull(mu, "用户信息不存在");
        // 用户名密码正确, 查询小区信息
        userVO.setRealName(mu.getRealName());
        userVO.setMobile(mu.getMobile());
        Community community = communityMapper.selectById(mu.getCommunityId());
        Assert.notNull(community, "没有归属小区");
        userVO.setCommunityName(community.getName());

        return userVO;
    }
}
