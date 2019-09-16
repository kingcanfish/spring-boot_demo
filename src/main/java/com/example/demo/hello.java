package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @Autowired
    private limitconfig limitconfig;
    @GetMapping("/hello")
    public String say(){
        return "minMoney" + limitconfig.getMinMoney() +limitconfig.getDesc();
    }
}

