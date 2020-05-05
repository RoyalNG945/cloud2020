package com.wuxin.springcloud.controller;

import com.wuxin.springcloud.entities.CommonResult;
import com.wuxin.springcloud.entities.Payment;
import com.wuxin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@Slf4j
public class PaymentController {


    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment){


        int result = paymentService.create(payment);
        log.info("*******新增结果 ==>{},serverPort==>{}",result,serverPort);
        if (result > 0){
            return new CommonResult(200,"新增成功serverPort= "+serverPort,result);
        }else {
            return new CommonResult(500,"新增失败",null);
        }

    }

    @GetMapping(value = "/{id}")
    public CommonResult<Payment> getById(@PathVariable("id")Long id){

        Payment payment = paymentService.getById(id);
        log.info("*******查询结果 ==>{},serverPort={}",payment,serverPort);
        if (Objects.nonNull(payment)){
            return new CommonResult(200,"查询成功serverPort= "+serverPort,payment);
        }else {
            return new CommonResult(500,"查询失败,id= "+id,null);
        }

    }


}
