package com.wiesen.parking.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName
@Data
public class CarPlate extends BaseEntity {

    private String plateNumber;

    private String ownerName;

    private String ownerPhone;

}
