package com.example.homework.service;

import com.example.homework.entity.Item_view;
import com.example.homework.entity.Repo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public boolean update(Repo repo, int id) {
        String sql = "UPDATE  repo SET repo_name=? WHERE repo_id=?";
        try {
            jdbcTemplate.update(sql, repo.getRepo_name(), id);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public List<Repo> findRepoById(int id){
        String sql = "SELECT * FROM repo WHERE repo_id=" + id;
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Repo repo = new Repo();
                repo.setRepo_name(resultSet.getString("repo_name"));
                repo.setRepo_type(resultSet.getInt("repo_type"));
                repo.setRepo_id(resultSet.getInt("repo_id"));
                return repo;
            });
        }catch (Exception e){
            return null;
        }
    }

    public List<Item_view> getRepoItem(int id){
        String sql = "SELECT * FROM item_view WHERE repo_id=" + id;
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Item_view itemView = new Item_view();
                itemView.setItem_name(resultSet.getString("item_name"));
                itemView.setUnit(resultSet.getString("unit"));
                itemView.setPrice(resultSet.getInt("price"));
                itemView.setPic_url(resultSet.getString("pic_url"));
                itemView.setNum(resultSet.getInt("num"));
                itemView.setRepo_id(resultSet.getInt("repo_id"));
                return itemView;
            });
        }catch (Exception e){
            return null;
        }

    }

    public List<Repo> getAllRepos(){
        String sql = "SELECT * FROM repo";
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Repo repo = new Repo();
                repo.setRepo_name(resultSet.getString("repo_name"));
                repo.setRepo_type(resultSet.getInt("repo_type"));
                repo.setRepo_id(resultSet.getInt("repo_id"));
                return repo;
            });
        }catch (Exception e){
            return null;
        }
    }

}
