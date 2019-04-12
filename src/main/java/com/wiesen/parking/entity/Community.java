package com.wiesen.parking.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName
public class Community extends BaseEntity {

    private String name;

}
