package com.wiesen.parking.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginVO {

    @NotNull(message = "登录名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    private String password;
}
