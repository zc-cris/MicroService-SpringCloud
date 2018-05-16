package com.cris.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cris.springcloud.entity.Dept;

@Mapper
public interface DeptMapper {

    public boolean saveDept(Dept dept);
    
    public Dept getDeptById(Integer id);
    
    public List<Dept> listDepts();
    
}
