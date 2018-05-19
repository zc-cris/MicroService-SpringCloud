package com.cris.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cris.springcloud.entity.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

    @Override
    public DeptClientService create(Throwable arg0) {
        
        return new DeptClientService() {
            
            @Override
            public boolean save(Dept dept) {
                
                return false;
            }
            
            @Override
            public List<Dept> list() {
                return null;
            }
            
            @Override
            public Dept get(Integer id) {
                if(arg0 instanceof RuntimeException) {
                    return new Dept().setId(id).setName("该id对应的数据没有在数据库中找到----DeptClientServiceFallbackFactory").setDb_source("no database in mysql");
                }
                return new Dept().setId(id).setDb_source(null).setName("服务当前不可用");
            }
            
            @Override
            public Object discovery() {
                
                return null;
            }
        };
    }

}
