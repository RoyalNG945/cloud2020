package com.wuxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Emma Watson
 * @create 2020-05-08 8:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientMain3355 {

    public static void main(String[] args) {

        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}
