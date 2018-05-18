package com.cris.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cris.springcloud.entity.Dept;

@RestController
public class DeptController_Consumer {
    
    @Autowired
    private RestTemplate restTemplate;
    
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    // 通过微服务提供模块的微服务名字来进行访问（使用Ribbon 负载均衡和Eureka 集群）
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";  
    
    
    @PostMapping("/consumer/dept/save")
 // 这里如果不用@RequestBody注解，那么前台发送过来的数据不能是json 格式，否则无法解析
    public boolean save(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/save", dept, Boolean.class);
    }
    
    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }
    
    @SuppressWarnings("unchecked")
    @GetMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }
    
    @GetMapping("/consumer/dept/discovery")
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }
    
    

}
