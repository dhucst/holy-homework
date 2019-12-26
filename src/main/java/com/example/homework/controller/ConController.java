package com.example.homework.controller;

import com.example.homework.entity.Contract;
import com.example.homework.entity.ResEntity;
import com.example.homework.entity.Todo_contract;
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

    //创建采购合同
    @RequestMapping(value = "/",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody
    ResEntity new_con(@RequestBody Contract contract){
        boolean result = conService.create(contract);
        if(!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    //根据contract_id查看合同信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_con(@PathVariable("id") int id) {
        ResEntity res = new ResEntity(200, "success");
        List<Contract> result = conService.findContractById(id);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }

    //查看未完成的合同信息
    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_todo_con(Todo_contract todo_contract) {
        ResEntity res = new ResEntity(200, "success");
        List<Todo_contract> result = conService.getContractTodo();
        if (result.size() <= 0)
            return new ResEntity(404,"Not found");
        res.setData(result);
        return res;
    }

    //查看所有合同(分页)
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_all_contract(@RequestParam int pageIndex, @RequestParam int pageSize) {
        ResEntity res = new ResEntity(200, "success");
        List<Contract> result = conService.getAllContracts(pageIndex, pageSize);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }

    //合同总数
    @RequestMapping(value = "/num", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_num() {
        ResEntity res = new ResEntity(200, "success");
        int result = conService.getContractNum();
        res.setData(result);
        return res;
    }




}
