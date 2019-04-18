package com.wiesen.parking.handler;

import com.wiesen.parking.exception.RestException;
import com.wiesen.parking.vo.Response;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ExceptionHandler(RestException.class)
    @ResponseBody
    public Response restErrorHandler(RestException re) {
        return Response.fail(re.getCode(), re.getMessage());
    }
}
