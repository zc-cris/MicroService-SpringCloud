package com.cris.springcloud.service;

import java.util.List;

import com.cris.springcloud.entity.Dept;

public interface DeptService {

    public boolean save(Dept dept);
    
    public Dept get(Integer id);
    
    public List<Dept> list();
    
}
