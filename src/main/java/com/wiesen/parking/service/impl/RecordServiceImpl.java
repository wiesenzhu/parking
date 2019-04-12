package com.wiesen.parking.service.impl;

import com.wiesen.parking.entity.RecordPO;
import com.wiesen.parking.mapper.CarRecordMapper;
import com.wiesen.parking.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private CarRecordMapper carRecordMappe;

    @Override
    public List<RecordPO> list(String value) {
        return carRecordMappe.queryByPlateOrPhone(value);
    }
}
