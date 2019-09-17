package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
//API 接口
@RestController
public class MoneyController {
    @Autowired
    private LuckmoneyRepository repository;
    @Autowired
    private LuckmoneyService service;
    @GetMapping("/money/all")
    public List<Luckmoney> list() {
         return repository.findAll();
    }
    @PostMapping("/money/create")
    public Luckmoney create(@RequestParam("send") String send,
                            @RequestParam("money")BigDecimal money){
        Luckmoney luckmoney = new Luckmoney();
        luckmoney.setMoney(money);
        luckmoney.setSend(send);
        return repository.save(luckmoney);

    }
    @GetMapping("/money/{id}")
    public Luckmoney find(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }
    @PutMapping("/money/{id}")
    protected Luckmoney change(@PathVariable("id") Integer id ,
                               @RequestParam("accept") String accept){
        Optional<Luckmoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckmoney luckmoney = optional.get();
            luckmoney.setAccept(accept);
            return repository.save(luckmoney);
        }
        return null;
    }

    @PostMapping("/money/two")
    public void createTwo() {
        service.createTwo();
    }

}