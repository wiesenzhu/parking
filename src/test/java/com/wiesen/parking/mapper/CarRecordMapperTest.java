package com.wiesen.parking.mapper;

import com.wiesen.parking.entity.CarRecord;
import com.wiesen.parking.entity.RecordPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarRecordMapperTest {

    @Autowired
    private CarRecordMapper carRecordMapper;

    @Test
    public void insertTest() {
        CarRecord cr = new CarRecord();
        cr.setType(1);
        cr.setReason("阿娘士大夫");
        int insert = carRecordMapper.insert(cr);
        System.out.println(insert);
    }

    @Test
    public void queryByPlateOrPhoneTest() {
//        List<RecordPO> recordPOS = carRecordMapper.queryByPlateOrPhone("13282810619");
    }

}