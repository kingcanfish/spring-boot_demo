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
        LuckMoney luckmoney1 = new LuckMoney();
        luckmoney1.setMoney(new BigDecimal("520"));
        luckmoney1.setSend("郭");
        luckmoneyRepository.save(luckmoney1);

        LuckMoney luckmoney2 = new LuckMoney();
        luckmoney2.setMoney(new BigDecimal("1314"));
        luckmoney2.setSend("郭");
        luckmoneyRepository.save(luckmoney2);

    }
}
