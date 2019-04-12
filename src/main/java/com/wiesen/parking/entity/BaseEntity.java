package com.wiesen.parking.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String createBy;

    private LocalDateTime createTime;

    private String modifyBy;

    private LocalDateTime modifyTime;

    private int isDeleted;
}
