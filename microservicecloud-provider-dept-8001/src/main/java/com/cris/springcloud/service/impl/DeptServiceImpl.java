package com.cris.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cris.springcloud.dao.DeptMapper;
import com.cris.springcloud.entity.Dept;
import com.cris.springcloud.service.DeptService;

// 为什么service 层的方法不和dao 层的方法保持一致，主要是考虑到和controller 层的rest 风格一致
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    
    @Override
    public boolean save(Dept dept) {

        return deptMapper.saveDept(dept);
    }

    @Override
    public Dept get(Integer id) {

        return deptMapper.getDeptById(id);
    }

    @Override
    public List<Dept> list() {

        return deptMapper.listDepts();
    }

}
