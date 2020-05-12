package com.wuxin.springcloud.controller;

import com.wuxin.springcloud.entities.CommonResult;
import com.wuxin.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author Emma Watson
 * @create 2020-05-10 21:21
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    public static HashMap<Long,Payment> hashMap = new HashMap<>(16);

    static {

        hashMap.put(1L,new Payment(1L,"1001"));
        hashMap.put(2L,new Payment(2L,"1002"));
        hashMap.put(3L,new Payment(3L,"1003"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSqlId(@PathVariable("id")Long id){

        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverport: "+serverPort,payment);
        return result;
    }

}

