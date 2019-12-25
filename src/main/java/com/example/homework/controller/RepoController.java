package com.example.homework.controller;

import com.example.homework.entity.Item_view;
import com.example.homework.entity.Repo;
import com.example.homework.entity.ResEntity;
import com.example.homework.service.RepoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;

@Controller
@RequestMapping("/repo")
public class RepoController {

    @Resource
    private RepoService repoService;

    @RequestMapping(value = "/", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    ResEntity new_repo(@RequestBody Repo repo) {
        boolean result = repoService.create(repo);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
    public @ResponseBody
    ResEntity update_repo(@RequestBody Repo repo, @PathVariable("id") int id) {
        boolean result = repoService.update(repo, id);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_repo(@PathVariable("id") int id) {
        ResEntity res = new ResEntity(200, "success");
        List<Repo> result = repoService.findRepoById(id);
        if (result.size() <= 0)
            return new ResEntity(404, "Not found");
        res.setData(result);
        return res;
    }

    @RequestMapping(value = "/{id}/items", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody
    ResEntity get_repo_items(@PathVariable("id") int id) {
        ResEntity res = new ResEntity(200, "success");
        List<Item_view> result = repoService.getRepoItem(id);
        if (result.size() > 0) {
            res.setData(result);
            return res;
        } else {
            return new ResEntity(404, "Not found");
        }
    }
}
