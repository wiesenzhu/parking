package com.wiesen.parking.service.impl;

import com.wiesen.parking.ParkingApplicationTests;
import com.wiesen.parking.service.UserService;
import com.wiesen.parking.vo.LoginVO;
import com.wiesen.parking.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-12 13:41
 */
@Slf4j
public class UserServiceImplTest extends ParkingApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void doLogin() {
        LoginVO vo = new LoginVO();
        vo.setMobile("13282809400");
        vo.setPassword("123456");
        Long userId = userService.validLoginInfo(vo);
        Assert.notNull(userId, "未查出用户, 测试未通过");
    }

    @Test
    public void doExit() {
    }
}