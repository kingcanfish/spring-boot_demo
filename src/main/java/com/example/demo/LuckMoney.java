package com.example.demo;



import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.math.BigDecimal;




@Entity

public class LuckMoney {
    @Id
    @GeneratedValue
    private Integer _id;
    @Min(value = 10, message = "最小要发10块钱的红包哦～")
    private BigDecimal money;

    private String send;

    private String accept;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    BigDecimal getMoney() {
        return money;
    }

    void setMoney(BigDecimal money) {
        this.money = money;
    }

    String getSend() {
        return send;
    }

    void setSend(String send) {
        this.send = send;
    }

    String getAccept() {
        return accept;
    }

    void setAccept(String accept) {
        this.accept = accept;
    }
    public String no(){
        return "no people";
    }

    @Override
    public String toString() {
        return "Luckmoney{" +
                "_id=" + _id +
                ", money=" + money +
                ", send='" + send + '\'' +
                ", accept='" + accept + '\'' +
                '}';
    }
}
