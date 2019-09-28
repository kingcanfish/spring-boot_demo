package com.example.demo;

public class ReturnUtil {
    public static HttpResult success(Object object) {
        HttpResult httpResult = new HttpResult();
        httpResult.setMessage("成功");
        httpResult.setStatus(1);
        httpResult.setData(object);
        return httpResult;
    }


    public static  HttpResult error (String message) {
        HttpResult httpResult = new HttpResult();
        httpResult.setMessage(message);
        httpResult.setStatus(0);
        return httpResult;
    }
}
