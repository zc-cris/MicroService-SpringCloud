package com.cris.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer_Dystrix_Dashboard_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dystrix_Dashboard_App.class, args);
    }
}
