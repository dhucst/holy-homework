package com.example.homework.service;

import com.example.homework.entity.Item;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return false;
        }
        return true;
    }

    public boolean update(Item item, int id) {
        String sql = "UPDATE  item SET item_name=?,price=?,pic_url=? WHERE item_id=?";
        try {
            jdbcTemplate.update(sql, item.getItem_name(), item.getPrice(), item.getPic_url(), id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Item> findItemById(int id) {
        String sql = "SELECT * FROM item WHERE item_id=" + id;
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Item item = new Item();
                item.setItem_name(resultSet.getString("item_name"));
                item.setUnit(resultSet.getString("unit"));
                item.setPic_url(resultSet.getString("pic_url"));
                item.setItem_id(resultSet.getInt("item_id"));
                item.setPrice(resultSet.getInt("price"));
                return item;
            });
        } catch (Exception e) {
            return null;
        }
    }

    public List<Item> getAllItems(int pageIndex, int pageSize) {
        String sql = String.format("SELECT * FROM item LIMIT %d OFFSET %d", pageSize, pageSize * (pageIndex - 1));
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Item item = new Item();
                item.setItem_name(resultSet.getString("item_name"));
                item.setUnit(resultSet.getString("unit"));
                item.setPic_url(resultSet.getString("pic_url"));
                item.setItem_id(resultSet.getInt("item_id"));
                item.setPrice(resultSet.getInt("price"));
                return item;
            });
        } catch (Exception e) {
            return null;
        }
    }

}
