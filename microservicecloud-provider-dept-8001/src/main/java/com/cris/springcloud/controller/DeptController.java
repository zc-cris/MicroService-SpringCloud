package com.cris.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cris.springcloud.entity.Dept;
import com.cris.springcloud.service.DeptService;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @PostMapping("/dept/save")
    // @requestBody注解常用来处理content-type不是默认的application/x-www-form-urlcoded编码的内容，
    //比如说：application/json或者是application/xml等。一般情况下来说常用其来处理application/json类型
    //使用了这个注解，前台传递过来的数据必须是json 格式的，否则无法正常存储数据到数据库
    public boolean save(@RequestBody Dept dept) {
        return service.save(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return service.list();
    }

}
