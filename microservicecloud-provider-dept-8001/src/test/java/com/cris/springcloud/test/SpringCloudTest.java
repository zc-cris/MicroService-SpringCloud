package com.cris.springcloud.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cris.springcloud.dao.DeptMapper;
import com.cris.springcloud.service.DeptService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringCloudTest {

    @Autowired
    DeptMapper mapper;
    
    @Autowired
    DeptService service;
    
    @Autowired
    DataSource source;
    
    @Test
    public void contextLoads() throws SQLException {
//        System.out.println(mapper);
//        System.out.println(service);
        System.out.println(source.getClass());
        System.out.println(source.getConnection());
    }

}