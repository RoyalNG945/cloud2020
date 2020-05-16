package com.wuxin.snowflake.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Emma Watson
 * @create 2020-05-12 11:16
 */
@Service
public class OrderService {

    @Resource
    private IdGeneratorSnowflake idGenerator;

    public String getIDBySnowFlake(){

        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {

            threadPool.submit(()->{
                System.out.println(idGenerator.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }
}
