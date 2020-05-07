package com.wuxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author Emma Watson
 * @create 2020-05-07 22:40
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigCenterMain3344 {

    public static void main(String[] args) {

        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
