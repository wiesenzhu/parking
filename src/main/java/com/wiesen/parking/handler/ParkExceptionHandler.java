package com.wiesen.parking.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Description
 * @auther wiesen
 * @create 2019-04-14 19:07
 */
@ControllerAdvice
public class ParkExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String errorHandler(Model model, Exception e) {
        model.addAttribute("errMsg", "出错啦");
        return "error";
    }
}
