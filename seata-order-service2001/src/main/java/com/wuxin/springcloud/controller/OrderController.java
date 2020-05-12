package com.wuxin.springcloud.controller;

import com.wuxin.springcloud.domain.CommonResult;
import com.wuxin.springcloud.domain.Order;
import com.wuxin.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Emma Watson
 * @create 2020-05-11 17:54
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/order/create")
    public CommonResult create(Order order){

        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}
