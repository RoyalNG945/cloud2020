package com.wuxin.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced  // 使用给注解,让restTemplate具有负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

