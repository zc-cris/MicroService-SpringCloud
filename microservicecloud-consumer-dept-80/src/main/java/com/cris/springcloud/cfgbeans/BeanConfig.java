package com.cris.springcloud.cfgbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration              // @Configuration == applicationContext.xml
public class BeanConfig {
    
    // 往容器里面放入一个专门用于发送rest请求的模板类
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
