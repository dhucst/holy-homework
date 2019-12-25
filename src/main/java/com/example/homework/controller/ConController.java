package com.example.homework.controller;

import com.example.homework.entity.Contract;
import com.example.homework.entity.ResEntity;
import com.example.homework.service.ConService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/con")
public class ConController {
    @Resource
    private ConService conService;

    //创建
    @RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody
    ResEntity new_con(@RequestBody Contract contract){
        boolean result = conService.create(contract);
        if(!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    //更新
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    ResEntity update_con(@RequestBody Contract contract, @PathVariable("id") int id) {
        boolean result = conService.update(contract,id);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    //通过contract_id查看信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity select_con(@RequestBody Contract contract, @PathVariable("id") int id) {
        boolean result = conService.select(contract,id);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }


}
