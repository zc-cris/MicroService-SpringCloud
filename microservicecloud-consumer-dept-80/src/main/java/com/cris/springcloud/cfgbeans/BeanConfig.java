package com.cris.springcloud.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;

@Configuration              // @Configuration == applicationContext.xml
public class BeanConfig {
    
    // 往容器里面放入一个专门用于发送rest请求的模板类
    @Bean
    @LoadBalanced   // Spring Cloud Ribbon 是基于Netflix Ribbon 实现的一套客户端 负载均衡的工具
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public IRule myRule() {
        return new RandomRule();    // 用我们自己选择的随机算法替代默认的轮询算法
//        return new RetryRule();
    }

}
