package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class LuckmoneyService {
    @Autowired
    private LuckMoneyRepository luckmoneyRepository;
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


    public void getMoney(Integer id) throws Exception {
        Optional <LuckMoney> optional = luckmoneyRepository.findById(id);
        if (optional.isPresent()) {
            LuckMoney luckMoney = optional.get();
            BigDecimal money = luckMoney.getMoney();
            if (money.intValue() <  100) {
            //返回“不到100块都不够塞牙缝”
                throw new Exception(-2, "不到100块都不够塞牙缝");

            }else if (money.intValue() <= 200) {
                //宁好有钱
                throw new Exception(-3 , "那你也挺有钱的");

            }
        }


    }
}
