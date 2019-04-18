package com.wiesen.parking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wiesen.parking.entity.CarRecord;
import com.wiesen.parking.entity.RecordPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CarRecordMapper extends BaseMapper<CarRecord> {

    List<RecordPO> queryByPlateOrPhone(Map param);
}
