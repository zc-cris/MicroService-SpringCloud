package com.cris.springcloud.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

// 使用lombok 插件和jar包自动生成模板代码
@SuppressWarnings("serial")
@AllArgsConstructor // 全参构造器
@NoArgsConstructor  // 无参构造器
@Data               // 自定生成getter和setter...
@Accessors(chain=true)  // 可以链式调用自动生成的模板方法
public class Dept implements Serializable{  // 具有类表关系映射的javaBean，必须序列化
    private Integer id;     //主键id
    private String name;    //部门名称
    private String db_source;   // 来自于哪个数据库，微服务架构中一个服务可以对应一个数据库，同一信息可以存储到不同数据库
    
    // 自定义的有参构造器
    public Dept(String name) {
        super();
        this.name = name;
    }
    
    /*  测试lombok 是否可用以及链式调用注解是否生效   ok
    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setName("人力资源部").setId(2).setDb_source("db1");
        System.out.println(dept);
    }
     */

}
