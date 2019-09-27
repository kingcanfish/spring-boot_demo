package com.example.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component

public class TableConfig {
    @Value("$mytablename")
    private String mytablename;
}
