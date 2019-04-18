package com.wiesen.parking.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-16 22:44
 */
@Data
public class RecordAddVO {

    @NotNull(message = "车牌号不能为空")
    @NotEmpty
    @NotBlank
    private String plateNumber;
    //    @NotNull(message = "手机号不能为空")
    private String mobile;
    private String realName;
//    @NotNull(message = "理由不能为空")
    private String reason;
    @NotNull(message = "类型不能为空")
    private int type;

}
