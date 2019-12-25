package com.example.homework.entity;

import java.util.Date;

//创建实体对象
public class Constract {
    private int constract_id;
    private int provider_id;
    private int item_id;
    private int constract_num;
    private int price;
    private Date constract_date;
    private int act_num;

    public int getConstract_id() {
        return constract_id;
    }

    public void setConstract_id(int constract_id) {
        this.constract_id = constract_id;
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

    public int getConstract_num() {
        return constract_num;
    }

    public void setConstract_num(int constract_num) {
        this.constract_num = constract_num;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getConstract_date() {
        return constract_date;
    }

    public void setConstract_date(Date constract_date) {
        this.constract_date = constract_date;
    }

    public int getAct_num() {
        return act_num;
    }

    public void setAct_num(int act_num) {
        this.act_num = act_num;
    }
}
