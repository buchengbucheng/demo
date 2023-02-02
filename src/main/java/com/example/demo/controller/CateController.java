package com.example.demo.controller;

import com.example.demo.common.R;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/cate")
@CrossOrigin
public class CateController {

    @Autowired
    private UserService cateService;

    @GetMapping()
    public R getCateList() {
        return R.ok().put("data", cateService.list());
    }

    @GetMapping("/{id}")
    public R getCate(@PathVariable("id") Integer id) {
        return R.ok().put("data", cateService.getById(id));
    }

    @PostMapping()
    public R saveCate(@RequestBody User cate) {
        return cateService.save(cate) ? R.ok() : R.error();
    }

    @PutMapping
    public R updateCate(@RequestBody User cate) {
        return cateService.updateById(cate) ? R.ok() : R.error();
    }

    @DeleteMapping("{id}")
    public R removeCate(@PathVariable("id") Integer id) {
        return cateService.removeById(id) ? R.ok() : R.error();
    }
}