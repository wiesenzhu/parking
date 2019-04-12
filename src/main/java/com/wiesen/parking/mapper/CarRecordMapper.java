package com.wiesen.parking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wiesen.parking.entity.CarRecord;
import com.wiesen.parking.entity.RecordPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CarRecordMapper extends BaseMapper<CarRecord> {

    List<RecordPO> queryByPlateOrPhone(@Param("value") String value);
}
