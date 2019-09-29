package com.example.demo;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult handle(Exception e ) {
        if (e instanceof Exception) {
            Exception exception = (Exception) e;
            return ReturnUtil.error(exception.getCode(), exception.getMessage());
        }else {
            return ReturnUtil.error(-1, e.getMessage());
        }


    }


}
