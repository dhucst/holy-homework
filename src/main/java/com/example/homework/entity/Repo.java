package com.example.homework.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

public class Repo {
    private int repo_id;
    private String repo_name;
    private int repo_type;

    public int getRepo_id() {
        return repo_id;
    }

    public void setRepo_id(int repo_id) {
        this.repo_id = repo_id;
    }

    public String getRepo_name() { return repo_name; }

    public void setRepo_name(String repo_name) { this.repo_name = repo_name; }

    public int getRepo_type() {
        return repo_type;
    }

    public void setRepo_type(int repo_type) {
        this.repo_type = repo_type;
    }
}
