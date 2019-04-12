package com.wiesen.parking.mapper;

import com.wiesen.parking.ParkingApplicationTests;
import com.wiesen.parking.entity.ManageUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ManageUserMapperTest extends ParkingApplicationTests {

    @Autowired
    private ManageUserMapper manageUserMapper;

    @Test
    public void insertTest() {
        ManageUser mu = new ManageUser();
        mu.setCommunityId(1L);
        mu.setMobile("13282809475");
        mu.setPassword("123456");
        mu.setRealName("张三");
        mu.setUsername("zhangs");
        int insert = manageUserMapper.insert(mu);
        System.out.println(insert);
    }

}