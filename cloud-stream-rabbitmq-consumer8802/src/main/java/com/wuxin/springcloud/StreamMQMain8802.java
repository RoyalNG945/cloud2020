package com.wuxin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Emma Watson
 * @create 2020-05-08 17:09
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StreamMQMain8802 {

    public static void main(String[] args) {

        SpringApplication.run(StreamMQMain8802.class,args);
    }

}
