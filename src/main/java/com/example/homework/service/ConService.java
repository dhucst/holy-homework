package com.example.homework.service;

import com.example.homework.entity.Contract;
import com.example.homework.entity.Repo;
import com.example.homework.entity.ResEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.awt.datatransfer.SystemFlavorMap;
import java.util.Date;

@Service
public class ConService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    //创建
    public boolean create(Contract cons) {
        String sql = "INSERT INTO contract VALUES(null,?,?,?,?,?,?)";

        try {
            jdbcTemplate.update(sql, new Object[]{cons.getContract_num(), cons.getProvider_id(),cons.getItem_id(),cons.getPrice(),cons.getContract_date(),cons.getAct_num()});
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    //根据合同号contract_id更新
    public boolean update(Contract contract, int id) {
        String sql = "UPDATE contract SET contract_num=?,provider_id=?,item_id=?,price=?,contract_date=?,act_num=? WHERE contract_id=?";

        try {
            jdbcTemplate.update(sql, contract.getContract_num(), contract.getProvider_id(),contract.getItem_id(),contract.getPrice(),contract.getContract_date(),contract.getAct_num(),id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    //根据合同号contract_id查询
    public boolean select(Contract contract, int id) {
        String sql = "SELECT * FROM contract WHERE contract_id=?";

        try {
            jdbcTemplate.update(sql,d);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}


