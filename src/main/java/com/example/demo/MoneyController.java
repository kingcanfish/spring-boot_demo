package com.example.demo;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Luckmoney create(@RequestBody @Valid Luckmoney luckmoney, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println( bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        System.out.println(luckmoney.getMoney() + " " + luckmoney.getAccept());

        return repository.save(luckmoney);

    }
    @GetMapping("/money/{id}")
    public Luckmoney find(@PathVariable("id") Integer id){
        return repository.findById(id).orElse(null);
    }
    @PutMapping("/money/{id}")
    protected Luckmoney change(@PathVariable("id") Integer id ,
                               @RequestBody Luckmoney luckmoney){
        Optional<Luckmoney> optional = repository.findById(id);
        if (optional.isPresent()) {
            Luckmoney luckmoney9 = optional.get();
            luckmoney9.setAccept(luckmoney.getAccept());
            return repository.save(luckmoney9);
        }
        return null;
    }

    @PostMapping("/money/two")
    public void createTwo() {
        service.createTwo();
    }

}