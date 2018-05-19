package com.cris.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cris.springcloud.entity.Dept;
import com.cris.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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
    // 一旦调用服务方法失败并抛出异常后，会自动调用@HystrixCommand 标注好的fallbackMehod 调用类中指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Integer id) {
        Dept dept = service.get(id);
        if(dept == null) {
            throw new RuntimeException("该ID："+ id + "没有对应的记录");
        }
        return dept;
    }
    public Dept processHystrix_Get(@PathVariable("Id") Integer id) {
        return new Dept().setId(id).setName("该id对应的数据没有在数据库中找到----@HystrixCommond").setDb_source("no database in mysql");
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return service.list();
    }
    
    // 对外暴露提供服务信息的客户端，方便服务发现
    @Autowired
    private DiscoveryClient discoveryClient;
    
    @GetMapping("/dept/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println("-----------" + services);
        services.forEach(System.out::println);
        
        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance serviceInstance : instances) {
            System.out.println(serviceInstance.getServiceId()+"\t"+serviceInstance.getHost()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return this.discoveryClient;
        
    }

}
