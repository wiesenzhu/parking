package com.wiesen.parking.service;

import com.wiesen.parking.entity.RecordPO;
import com.wiesen.parking.vo.RecordAddVO;
import com.wiesen.parking.vo.UserVO;

import java.util.List;

public interface RecordService {

    List<RecordPO> list(String value, UserVO userVO);

    void add(RecordAddVO vo, UserVO userVO);
}
