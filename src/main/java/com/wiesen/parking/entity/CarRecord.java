package com.wiesen.parking.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName
public class CarRecord extends BaseEntity {

    private String ownerName;
    private String plateNumber;
    private String ownerPhone;
    private String reason;
    private int type;
    private Long communityId;
}
