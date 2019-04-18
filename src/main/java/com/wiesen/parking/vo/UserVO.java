package com.wiesen.parking.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVO {

    private Long userId;

    private String communityName;

    private Long communityId;

    private String mobile;

    private String realName;

}
