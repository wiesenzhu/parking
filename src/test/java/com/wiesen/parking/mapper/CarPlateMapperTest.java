package com.wiesen.parking.mapper;

import com.wiesen.parking.entity.CarPlate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarPlateMapperTest {

    @Autowired
    private CarPlateMapper carPlateMapper;

    @Test
    public void insertTest() {
        CarPlate cp = new CarPlate();
        cp.setPlateNumber("浙A00000");
        cp.setOwnerName("祝兵");
        cp.setOwnerPhone("13282810619");
        int insert = carPlateMapper.insert(cp);
        System.out.println(insert);
    }

}