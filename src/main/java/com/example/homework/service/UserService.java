package com.example.homework.service;


import com.example.homework.entity.Employee;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public boolean create(Employee employee) {

        String sql = String.format("INSERT INTO employee VALUES(null,'%s',null,%d,'%s')", employee.getEmp_name(), employee.getRole(), employee.getPwd());
        try {
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<Employee> valid(Employee employee) {

        String sql = String.format("SELECT * FROM employee WHERE emp_name='%s' AND pwd='%s'", employee.getEmp_name(), employee.getPwd());
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Employee employee1 = new Employee();
                employee1.setEmp_id(resultSet.getInt("emp_id"));
                employee1.setEmp_name(resultSet.getString("emp_name"));
                employee1.setRole(resultSet.getInt("role"));
                return employee1;
            });
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public List<Employee> getAllEmployees(int pageIndex, int pageSize) {
        String sql = String.format("SELECT * FROM employee LIMIT %d OFFSET %d", pageSize, pageSize * (pageIndex - 1));
        try {
            return jdbcTemplate.query(sql, (resultSet, i) -> {
                Employee employee = new Employee();
                employee.setEmp_name(resultSet.getString("emp_name"));
                employee.setRole(resultSet.getInt("role"));
                employee.setEmp_id(resultSet.getInt("emp_id"));
                return employee;
            });
        } catch (Exception e) {
            return null;
        }
    }


}
