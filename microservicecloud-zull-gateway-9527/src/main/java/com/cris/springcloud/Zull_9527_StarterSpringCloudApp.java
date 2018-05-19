package com.cris.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@SpringBootApplication
@EnableZuulProxy    // 开启zuul网关代理
public class Zull_9527_StarterSpringCloudApp {

    public static void main(String[] args) {
        SpringApplication.run(Zull_9527_StarterSpringCloudApp.class, args);
    }

}
