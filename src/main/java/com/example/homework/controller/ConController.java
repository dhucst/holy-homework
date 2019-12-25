package com.example.homework.controller;

import com.example.homework.entity.Contract_view;
import com.example.homework.entity.Contract;
import com.example.homework.entity.ResEntity;
import com.example.homework.service.ConService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;

@Controller
@RequestMapping("/con")
public class ConController {
    @Resource
    private ConService conService;

    //新建
    @RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody
    ResEntity new_con(@RequestBody Contract contract){
        boolean result = conService.create(contract);
        if(!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }


}
