package com.example.homework.service;

import com.example.homework.entity.Repo;
import com.example.homework.entity.ResEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service
public class RepoService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public boolean create(Repo repo) {
        String sql = "INSERT INTO repo VALUES(null,?,?)";
        try {
            jdbcTemplate.update(sql, repo.getRepo_name(), repo.getRepo_type());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
