package com.example.homework.controller;

import com.example.homework.entity.ReqRepo;
import com.example.homework.entity.ResEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/repo")
public class RepoController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResEntity new_repo(@RequestBody ReqRepo repo) {
        String sql = "INSERT INTO repo VALUES(null,?,?)";
        int n;
        n = jdbcTemplate.update(sql, repo.getRepo_name(), repo.getRepo_type());
        System.out.println(n);
        if (n >= 1) {
            return new ResEntity(500, "success");
        } else
            return new ResEntity(500, "failed");

    }


}
