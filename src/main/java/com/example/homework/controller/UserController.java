package com.example.homework.controller;

import com.example.homework.entity.Employee;
import com.example.homework.entity.Repo;
import com.example.homework.entity.ResEntity;
import com.example.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired     //实现接口自动化
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity new_user(@PathVariable("username") String username){
        ResEntity res = new ResEntity(200, "success");
        List<Employee> result = userService.getUsername(username);
        if(result.size()!=0)
        {
            Employee user1 = result.get(0);
            if(user1.getPwd().equals())

            }
        }
        return res;
    }

}
