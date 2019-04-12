package com.wiesen.parking.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginVO {

    @NotNull(message = "手机号不能为空")
    private String mobile;

    @NotBlank(message = "密码不能为空")
    private String password;
}
