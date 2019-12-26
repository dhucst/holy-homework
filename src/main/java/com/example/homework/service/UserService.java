package com.example.homework.service;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

}
