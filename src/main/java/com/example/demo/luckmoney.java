package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
public class luckmoney {
    @Id
    @GeneratedValue
    private Integer _id;
    private BigDecimal money;
    private String send;
    private String accept;

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public BigDecimal getMoney() {
        return money;
    }

    void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getSend() {
        return send;
    }

    void setSend(String send) {
        this.send = send;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }
    public String no(){
        return "nopeople";
    }
}
