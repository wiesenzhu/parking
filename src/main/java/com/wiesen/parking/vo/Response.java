package com.wiesen.parking.vo;

import lombok.Data;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-05 22:11
 */
@Data
public class Response<T> {

    public static final String SUCCESS_CODE = "0000";
    public static final String LOGIN_FAIL   = "0001";
    public static final String REG_FAIL     = "0002";

    public static final String FAIL_CODE    = "9999";

    private String code;

    private String msg;

    private T data;

    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Response<T> success() {
        return success(null);
    }

    public static <T> Response<T> success(T data) {
        return new Response<T>(SUCCESS_CODE, "请求成功", data);
    }

    public static Response fail(String code, String msg) {
        return new Response(code, msg);
    }

    public static Response fail() {
        return fail(FAIL_CODE, "请求失败");
    }

}
