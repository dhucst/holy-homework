package com.example.homework.entity;

import java.util.Date;

public class Contract_view {

    //item
    private int item_id;
    private String item_name;
    private String unit;
    private int price;
    private String pic_url;
    //employee
    private int emp_id;
    private String emp_name;
    private String avater_url;
    private int role;
    private String pwd;
    //contract
    private int contract_id;
    private int provider_id;
    private int contract_num;
    private Date contract_date;
    private int act_num;

    //item
    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPic_url() {
        return pic_url;
    }

    public void setPic_url(String pic_url) {
        this.pic_url = pic_url;
    }

    //employee
    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getAvater_url() {
        return avater_url;
    }

    public void setAvater_url(String avater_url) {
        this.avater_url = avater_url;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    //contract
    public int getContract_id() { return contract_id; }

    public void setContract_id(int contract_id) { this.contract_id = contract_id; }

    public int getProvider_id() { return provider_id; }

    public void setProvider_id(int provider_id) { this.provider_id = provider_id; }

    public int getContract_num() { return contract_num; }

    public void setContract_num(int contract_num) { this.contract_num = contract_num; }

    public Date getContract_date() { return contract_date; }

    public void setContract_date(Date contract_date) { this.contract_date = contract_date; }

    public int getAct_num() {
        return act_num;
    }

    public void setAct_num(int act_num) {
        this.act_num = act_num;
    }

}
