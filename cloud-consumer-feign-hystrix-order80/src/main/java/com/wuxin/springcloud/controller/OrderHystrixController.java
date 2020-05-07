package com.wuxin.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.wuxin.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;


    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_Ok(@PathVariable("id") Integer id){

        String result = paymentHystrixService.paymentInfo_Ok(id);
        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){

        String result = paymentHystrixService.paymentInfo_Timeout(id);
        return result;
    }


    public String paymentTimeoutFallbackMethod(Integer id){

        return "我是消费者80，对方支付系统繁忙，请10秒后重试或者自己运行出错，请检查自己!/(ㄒoㄒ)/~~";
    }

    /**
     * 全局 fallback 方法
     * @return
     */
    public String payment_Global_FallbackMethod(){

        return "global异常处理信息，请稍后重试！/(ㄒoㄒ)/~~";
    }

}
