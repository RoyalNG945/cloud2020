package com.wuxin.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {


    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id){

        return "线程池: "+ Thread.currentThread().getName() + "paymentInfo_Ok,id: "+id+"\t"+"O(∩_∩)O哈哈~";

    }


    /**
     * 超时访问
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id){

        int timeNumber = 5;
        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+ Thread.currentThread().getName() + "paymentInfo_Timeout,id: "+id+"\t"+"O(∩_∩)O哈哈~"+" 耗时"+timeNumber+"秒钟";

    }


    public String paymentInfo_TimeoutHandler(Integer id){

        return "线程池: "+ Thread.currentThread().getName() + "paymentInfo_Timeout,id: "+id+"\t"+"o(╥﹏╥)o";
    }

}
