package com.example.homework.entity;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.Date;

//创建实体对象
public class Contract {
    private int contract_id;
    private int provider_id;
    private int item_id;
    private int contract_num;
    private int price;
    private Date contract_date;
    private int act_num;

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getContract_num() {
        return contract_num;
    }

    public void setContract_num(int contract_num) {
        this.contract_num = contract_num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getContract_date() {
        return contract_date;
    }

    public void setContract_date(Date contract_date) {
        this.contract_date = contract_date;
    }

    public int getAct_num() {
        return act_num;
    }

    public void setAct_num(int act_num) {
        this.act_num = act_num;
    }
}
