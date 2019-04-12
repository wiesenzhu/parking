package com.wiesen.parking.entity;

import lombok.Data;

@Data
public class CarRecord extends BaseEntity {

    private Long plateId;

    private int type;

    private String reason;
}
