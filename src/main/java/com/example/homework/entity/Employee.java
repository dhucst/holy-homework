package com.example.homework.entity;

//创建实体对象
public class Employee {
    private int emp_id;
    private String emp_name;
	private String avater_url;
	private int role;
	private String pwd;

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

}
