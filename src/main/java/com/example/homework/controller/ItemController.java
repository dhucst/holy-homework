package com.example.homework.controller;

import com.example.homework.entity.Item;
import com.example.homework.entity.ResEntity;
import com.example.homework.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Resource
    private ItemService itemService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResEntity new_item(@RequestBody Item item) {
        boolean result = itemService.create(item);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    ResEntity update_item(@RequestBody Item item, @PathVariable("id") int id) {
        boolean result = itemService.update(item, id);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_item(@PathVariable("id") int id) {
        ResEntity res = new ResEntity(200, "success");
        List<Item> result = itemService.findItemById(id);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_all_item(@RequestParam int pageIndex, @RequestParam int pageSize) {
        ResEntity res = new ResEntity(200, "success");
        List<Item> result = itemService.getAllItems(pageIndex, pageSize);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }

}
