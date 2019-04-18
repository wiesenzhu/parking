package com.wiesen.parking.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-16 21:45
 */
@Data
public class RegisterVO {

    @NotNull(message = "手机号不能为空")
    private String mobile;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "姓名不能为空")
    private String realName;
    @NotNull(message = "所属小区不能为空")
    private Long communityId;

}
