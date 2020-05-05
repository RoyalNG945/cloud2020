package com.wuxin.springcloud.controller;

import com.wuxin.springcloud.entities.CommonResult;
import com.wuxin.springcloud.entities.Payment;
import com.wuxin.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {


    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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
        log.info("*******查询结果 ==>{},hahaheiheixixi",payment);
        if (Objects.nonNull(payment)){
            return new CommonResult(200,"查询成功serverPort= "+serverPort,payment);
        }else {
            return new CommonResult(500,"查询失败,id= "+id,null);
        }

    }

    @GetMapping(value = "/info")
    public Object getInfo(){

        List<String> services = discoveryClient.getServices();
        services.forEach(

                s -> log.info("service info ==>{}",s)
        );

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        instances.forEach(instance->{

            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());

        });

        return discoveryClient;

    }

    @GetMapping("/payment/get/port")
    public String getPort(){

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }


}
