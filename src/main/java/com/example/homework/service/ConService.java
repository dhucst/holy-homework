package com.example.homework.service;

import com.example.homework.entity.Contract;
import com.example.homework.entity.Item;
import com.example.homework.entity.Todo_contract;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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

            jdbcTemplate.update(sql, contract.getProvider_id(), contract.getItem_id(), contract.getContract_num(), contract.getPrice(), contract.getContract_date(), contract.getProcesser(), contract.getAct_num());
        } catch (Exception e) {
            System.out.println(contract.getContract_id());
            return false;
        }
        return true;
    }

    //根据contract_id查看合同信息
    public List<Contract> findContractById(int id) {
        String sql = "SELECT * FROM contract WHERE contract_id=" + id;
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Contract contract = new Contract();

                contract.setContract_id(resultSet.getInt("contract_id"));
                contract.setProvider_id(resultSet.getInt("provider_id"));
                contract.setItem_id(resultSet.getInt("item_id"));
                contract.setContract_num(resultSet.getInt("contract_num"));
                contract.setPrice(resultSet.getInt("price"));
                contract.setContract_date(resultSet.getDate("contract_date"));
                contract.setProcesser(resultSet.getInt("processer"));
                contract.setAct_num(resultSet.getInt("act_num"));

                return contract;
            });
        } catch (Exception e) {
            return null;
        }
    }

    //查看未完成的合同信息
    public List<Todo_contract> getContractTodo() {
        String sql = "SELECT * FROM todo_contract";
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Todo_contract todoContract = new Todo_contract();
                todoContract.setContract_id(resultSet.getInt("contract_id"));
                todoContract.setProvider_id(resultSet.getInt("provider_id"));
                todoContract.setItem_id(resultSet.getInt("item_id"));
                todoContract.setContract_num(resultSet.getInt("contract_num"));
                todoContract.setPrice(resultSet.getInt("price"));
                todoContract.setContract_date(resultSet.getDate("contract_date"));
                todoContract.setProcesser(resultSet.getInt("processer"));
                todoContract.setAct_num(resultSet.getInt("act_num"));
                return todoContract;
            });
        } catch (Exception e) {
            return null;
        }
    }

    //查看所有合同(分页)
    public List<Contract> getAllContracts(int pageIndex, int pageSize) {
        String sql = String.format("SELECT * FROM contract LIMIT %d OFFSET %d", pageSize, pageSize * (pageIndex - 1));
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Contract contract = new Contract();
                contract.setContract_id(resultSet.getInt("contract_id"));
                contract.setProvider_id(resultSet.getInt("provider_id"));
                contract.setItem_id(resultSet.getInt("item_id"));
                contract.setContract_num(resultSet.getInt("contract_num"));
                contract.setPrice(resultSet.getInt("price"));
                contract.setContract_date(resultSet.getDate("contract_date"));
                contract.setProcesser(resultSet.getInt("processer"));
                contract.setAct_num(resultSet.getInt("act_num"));

                return contract;
            });
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public int getContractNum() {
        String sql = "SELECT COUNT(*) AS num FROM contract";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception e) {
            return 0;
        }
    }

}


