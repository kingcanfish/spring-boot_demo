package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class MoneyController {
    @Autowired
    private LuckmoneyRepository repository;
    @Autowired
    private LuckmoneyService service;
    @GetMapping("/money/all")
    public List<luckmoney> list(){
         return repository.findAll();
    }
    @PostMapping("/moneyy/create")
    public luckmoney create(@RequestParam("send") String send,
                            @RequestParam("money")BigDecimal money){
        luckmoney luckmoney = new luckmoney();
        luckmoney.setMoney(money);
        luckmoney.setSend(send);
        return repository.save(luckmoney);

    }
    @GetMapping("/money/{id}")
    public luckmoney find(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }
    @PutMapping("/money/{id}")
    protected luckmoney change(@PathVariable("id") Integer id ,
                               @RequestParam("accept") String accept){
        Optional<luckmoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            luckmoney luckmoney = optional.get();
            luckmoney.setAccept(accept);
            return repository.save(luckmoney);
        }
        return null;
    }

    @PostMapping("/money/two")
    public void createTwo(){
        service.createTwo();
    }

}