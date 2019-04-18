package com.wiesen.parking.service.impl;

import com.wiesen.parking.entity.CarRecord;
import com.wiesen.parking.entity.ManageUser;
import com.wiesen.parking.entity.RecordPO;
import com.wiesen.parking.filter.UserHolder;
import com.wiesen.parking.mapper.CarRecordMapper;
import com.wiesen.parking.mapper.ManageUserMapper;
import com.wiesen.parking.service.RecordService;
import com.wiesen.parking.vo.RecordAddVO;
import com.wiesen.parking.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private CarRecordMapper carRecordMappe;

    @Override
    public List<RecordPO> list(String value, UserVO userVO) {
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("value", value);
        paramMap.put("communityId", userVO.getCommunityId().toString());
        return carRecordMappe.queryByPlateOrPhone(paramMap);
    }

    @Override
    public void add(RecordAddVO vo, UserVO userVO) {
        CarRecord cr = new CarRecord();
        BeanUtils.copyProperties(vo, cr);
        cr.setOwnerPhone(vo.getMobile());
        cr.setOwnerName(vo.getRealName());
        cr.setCreateTime(LocalDateTime.now());
        cr.setCreateBy(userVO.getUserId().toString());
        cr.setCommunityId(userVO.getCommunityId());
        carRecordMappe.insert(cr);
    }
}
