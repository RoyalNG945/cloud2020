package com.wuxin.springcloud.controller;

import com.wuxin.springcloud.entities.CommonResult;
import com.wuxin.springcloud.entities.Payment;
import com.wuxin.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getById(@PathVariable(value = "id") Long id){

        CommonResult<Payment> result = paymentFeignService.getById(id);
        log.info("getById result use feign success ===>{}",result);
        return result;
    }

    @GetMapping("/consumer/payment/get/port")
    public String getPort(){
        String port = paymentFeignService.getPort();
        return port;
    }

}
