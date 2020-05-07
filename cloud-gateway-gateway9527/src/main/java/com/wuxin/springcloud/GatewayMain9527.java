package com.wuxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Emma Watson
 * @create 2020-05-07 15:17
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMain9527 {

    public static void main(String[] args) {

        SpringApplication.run(GatewayMain9527.class,args);
    }
}
