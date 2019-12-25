package com.example.homework.controller;

import com.example.homework.entity.Repo;
import com.example.homework.entity.ResEntity;
import com.example.homework.service.RepoService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        boolean result = repoService.update(repo,id);
        if (!result)
            return new ResEntity(500, "failed");
        return new ResEntity(200, "success");
    }


}
