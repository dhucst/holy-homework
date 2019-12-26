package com.example.homework.entity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

//创建实体对象
public class Item_Log {

    private int log_id;
    private Date in_date;
    private int repo_id;

    private int item_id;
    private int num;
    private int contract_id;
    private int processer;

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public Date getIn_date() {
        return in_date;
    }

    public void setIn_date(Date in_date) {
        this.in_date = in_date;
    }

    public int getRepo_id() {
        return repo_id;
    }

    public void setRepo_id(int repo_id) {
        this.repo_id = repo_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getContract_id() {
        return contract_id;
    }

    public void setContract_id(int contract_id) {
        this.contract_id = contract_id;
    }

    public int getProcesser(){
        return processer;
    }

    public void  setProcesser(int processer){
        this.processer = processer;
    }
}
