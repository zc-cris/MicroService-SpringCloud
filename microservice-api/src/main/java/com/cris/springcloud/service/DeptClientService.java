package com.cris.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cris.springcloud.entity.Dept;

//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {
    
    @PostMapping("/dept/save")
    public boolean save(Dept dept);
    
    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") Integer id);
    
    @GetMapping("/dept/list")
    public List<Dept> list();
    
    @GetMapping("/dept/discovery")
    public Object discovery();

}
