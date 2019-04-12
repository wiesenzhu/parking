package com.wiesen.parking.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName
public class ManageUser extends BaseEntity {

    private Long communityId;

    private String username;

    private String password;

    private String mobile;

    private String realName;

}
