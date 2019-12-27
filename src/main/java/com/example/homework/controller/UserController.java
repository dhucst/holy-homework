package com.example.homework.controller;

import com.example.homework.entity.Employee;
import com.example.homework.entity.ResEntity;
import com.example.homework.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResEntity login(@RequestBody Employee employee) {
        List<Employee> result = userService.valid(employee);
        if (result.size() > 0) {
            ResEntity res = new ResEntity(200, "success");
            res.setData(result);
            return res;
        }
        return new ResEntity(400, "failed");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResEntity new_item(@RequestBody Employee employee) {
        boolean result = userService.create(employee);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_all_item(@RequestParam int pageIndex, @RequestParam int pageSize) {
        ResEntity res = new ResEntity(200, "success");
        List<Employee> result = userService.getAllEmployees(pageIndex, pageSize);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }
    
}
