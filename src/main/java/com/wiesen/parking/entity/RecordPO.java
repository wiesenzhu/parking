package com.wiesen.parking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-05 22:22
 */
@Data
public class RecordPO {

    private String plateNumber;
    private String ownerName;
    private String ownerPhone;
    private int type;
    private String reason;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    @DateTimeFormat(pattern = )
    private Date recTime;
}
