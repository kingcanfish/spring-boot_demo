package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckmoneyService {
    @Autowired
    private LuckmoneyRepository luckmoneyRepository;
    @Transactional
    public void createTwo(){
        luckmoney luckmoney1 = new luckmoney();
        luckmoney1.setMoney(new BigDecimal("520"));
        luckmoney1.setSend("郭");
        luckmoneyRepository.save(luckmoney1);

        luckmoney luckmoney2 = new luckmoney();
        luckmoney2.setMoney(new BigDecimal("1314"));
        luckmoney2.setSend("郭");
        luckmoneyRepository.save(luckmoney2);

    }
}
