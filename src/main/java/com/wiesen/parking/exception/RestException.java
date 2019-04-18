package com.wiesen.parking.exception;

import lombok.Data;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-16 21:56
 */
@Data
public class RestException extends RuntimeException {

    private String code;

    public RestException() {
        super();
    }

    public RestException(String msg, String code) {
        super(msg);
        this.code = code;
    }
}
