package com.wiesen.parking.service;

import com.wiesen.parking.entity.RecordPO;

import java.util.List;

public interface RecordService {

    List<RecordPO> list(String value);
}
