package com.example.homework.service;

import com.example.homework.entity.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ItemService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public boolean create(Item item) {
        String sql = "INSERT INTO item VALUES(null,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, item.getItem_name(), item.getUnit(), item.getPrice(), item.getPic_url());
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean update(Item item, int id) {
        String sql = "UPDATE  item SET item_name=? WHERE item_id=?";
        try {
            jdbcTemplate.update(sql, item.getItem_name(), id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
