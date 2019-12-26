package com.example.homework.controller;

import com.example.homework.entity.*;
import com.example.homework.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/storage")
public class StorageInputController {
    @Resource
    private StorageService storageService;

    //入库记录
    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResEntity new_item_log(@RequestBody Item_Log item_log) {
        boolean result = storageService.create(item_log);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }
    //查看入库信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_item_log(@PathVariable("id") int id) {
        ResEntity res = new ResEntity(200, "success");
        List<Item_Log> result = storageService.findItemLogById(id);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }

    //查看入库列表
    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_all_Storage(@RequestParam int pageIndex, @RequestParam int pageSize) {
        ResEntity res = new ResEntity(200, "success");
        List<Item_Log> result = storageService.getAllStorage(pageIndex, pageSize);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }

    //查看入库记录总数
    @RequestMapping(value = "/num", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity Get_log_num() {
        ResEntity res = new ResEntity(200,"success");
        int result = storageService.inquire();
        res.setData(result);
        return res;

    }
}
