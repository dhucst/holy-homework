package com.example.homework.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/user")
public class UserController {

    private JdbcTemplate jdbcTemplate;
/*
    @RequestMapping(value = "/login", method = POST, produces = "application/json")
    public WebResponse<Map<String, Object>> login(@RequestBody Article article){

    }
    */
}
