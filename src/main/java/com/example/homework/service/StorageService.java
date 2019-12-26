package com.example.homework.service;

import com.example.homework.entity.Item_Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class StorageService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public boolean create(Item_Log item_log) {

        //String sql = String.format("call Add_Item(pItem_id=?,pRepo_id=?,pCon_id=?,pNum=?,pProcesser=?)",);
        String sql = String.format("call Add_Item(%d,%d,%d,%d,%d)",item_log.getItem_id(),item_log.getRepo_id(),item_log.getContract_id(),item_log.getNum(),item_log.getProcesser());
        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(item_log.getItem_id());
            return false;
        }
        return true;
    }

    public List<Item_Log> findItemLogById(int id){
        String sql = "SELECT * FROM item_log WHERE log_id=" + id;
        try {
            return jdbcTemplate.query(sql,  new RowMapper<Item_Log>() {
                @Override
                public Item_Log mapRow(ResultSet resultSet, int i) throws SQLException {
                    Item_Log item_log = new Item_Log();
                    item_log.setItem_id(resultSet.getInt("item_id"));
                    item_log.setRepo_id(resultSet.getInt("repo_id"));
                    item_log.setNum(resultSet.getInt("num"));
                    item_log.setContract_id(resultSet.getInt("contract_id"));
                    item_log.setProcesser(resultSet.getInt("processer"));
                    return item_log;
                }
            });
        }catch (Exception e){
            return null;
        }
    }
}
