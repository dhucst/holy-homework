package com.example.homework.service;

import com.example.homework.entity.Contract_view;
import com.example.homework.entity.Contract;
import com.example.homework.entity.ResEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Service
public class ConService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    //新建
    public boolean create(Contract contract) {
        String sql = "INSERT INTO contract VALUES(null,?,?,?,?,?,?,?)";
        try {
            //日期
            Contract date = new Contract();
            date.setContract_date(new Date());

            jdbcTemplate.update(sql,contract.getProvider_id(),contract.getItem_id(),contract.getContract_num(),contract.getPrice(),contract.getContract_date(),contract.getProcesser(),contract.getAct_num());
        } catch (Exception e) {
            //System.out.println(e.toString());
            return false;
        }
        return true;
    }

}


