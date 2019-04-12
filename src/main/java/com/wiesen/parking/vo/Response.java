package com.wiesen.parking.vo;

import lombok.Data;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-05 22:11
 */
@Data
public class Response<T> {

    private String code;

    private String msg;

    private T data;
}
