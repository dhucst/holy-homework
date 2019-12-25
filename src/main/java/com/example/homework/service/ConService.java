package com.example.homework.service;

import com.example.homework.entity.Todo_contract;
import com.example.homework.entity.Contract;
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

    //创建采购合同
    public boolean create(Contract contract) {
        String sql = "INSERT INTO contract VALUES(null,?,?,?,?,?,?,?)";
        try {
            //日期
            Contract date = new Contract();
            date.setContract_date(new Date());

            jdbcTemplate.update(sql,contract.getProvider_id(),contract.getItem_id(),contract.getContract_num(),contract.getPrice(),contract.getContract_date(),contract.getProcesser(),contract.getAct_num());
        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    //根据contract_id查看合同信息
    public List<Contract> findContractById(int id){
        String sql = "SELECT * FROM contract WHERE contract_id=" + id;
        try {
            return jdbcTemplate.query(sql, new RowMapper<Contract>() {
                @Override
                public Contract mapRow(ResultSet resultSet, int i) throws SQLException {
                    Contract contract = new Contract();

                    contract.setProvider_id(resultSet.getInt("provider_id"));
                    contract.setItem_id(resultSet.getInt("item_id"));
                    contract.setContract_num(resultSet.getInt("contract_num"));
                    contract.setPrice(resultSet.getInt("price"));
                    contract.setContract_date(resultSet.getDate("contract_date"));
                    contract.setProcesser(resultSet.getInt("processer"));
                    contract.setAct_num(resultSet.getInt("act_num"));

                    return contract;
                }
            });
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }

    //查看未完成的合同信息
    public List<Todo_contract> getContractTodo(){
        String sql = "SELECT * FROM todo_contract";
        try {
            return jdbcTemplate.query(sql, new RowMapper<Todo_contract>() {
                @Override
                public Todo_contract mapRow(ResultSet resultSet, int i) throws SQLException {
                    Todo_contract todoContract = new Todo_contract();

                    todoContract.setProvider_id(resultSet.getInt("provider_id"));
                    todoContract.setItem_id(resultSet.getInt("item_id"));
                    todoContract.setContract_num(resultSet.getInt("contract_num"));
                    todoContract.setPrice(resultSet.getInt("price"));
                    todoContract.setContract_date(resultSet.getDate("contract_date"));
                    todoContract.setProcesser(resultSet.getInt("processer"));
                    todoContract.setAct_num(resultSet.getInt("act_num"));

                    return todoContract;
                }
            });
        }catch (Exception e){
            System.out.println(e.toString());
            return null;
        }
    }


}


