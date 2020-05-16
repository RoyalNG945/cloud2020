package com.wuxin.snowflake.controller;

import com.wuxin.snowflake.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Emma Watson
 * @create 2020-05-12 11:24
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/snowflake")
    public String snowFlake(){

        return orderService.getIDBySnowFlake();
    }
}
