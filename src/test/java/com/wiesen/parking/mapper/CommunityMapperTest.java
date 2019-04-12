package com.wiesen.parking.mapper;

import com.wiesen.parking.ParkingApplicationTests;
import com.wiesen.parking.entity.Community;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunityMapperTest extends ParkingApplicationTests {

    @Autowired
    private CommunityMapper communityMapper;

    @Test
    public void insertTest() {
        Community c = new Community();
        c.setName("樱花府第");
        int insert = communityMapper.insert(c);
        System.out.println(insert);
    }

}