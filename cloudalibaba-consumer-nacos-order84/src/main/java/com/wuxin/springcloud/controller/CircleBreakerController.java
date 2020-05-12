package com.wuxin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wuxin.springcloud.entities.CommonResult;
import com.wuxin.springcloud.entities.Payment;
import com.wuxin.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sun.awt.SunHints;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Emma Watson
 * @create 2020-05-10 21:37
 */
@RestController
public class CircleBreakerController {


    private static String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")  //没有配置兜底方法
//    @SentinelResource(value = "fallback",fallback = "handlerFallback") //fallback只负责业务异常,管理运行异常
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规
    @SentinelResource(value = "fallback",
                        blockHandler = "blockHandler",
                        fallback = "handlerFallback",
                        exceptionsToIgnore = {IllegalArgumentException.class})
    public CommonResult<Payment> fallback(@PathVariable("id")Long id){

        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if(id == 4){
            throw new IllegalArgumentException("IllegalArgumentException 非法参数异常");
        }else if (Objects.isNull(result.getData())){
            throw new NullPointerException("NullPointerException 该ID 没有对应记录，空指针异常");
        }
        return result;
    }

    // 本例是fallback
    public CommonResult handlerFallback(Long id,Throwable e){

        Payment payment = new Payment(id,null);
        return new CommonResult(444,"兜底异常handlerFallback exception内容："+e.getMessage(),payment);
    }

    //本例是blockHandler
    public CommonResult blockHandler(Long id,BlockException e){

        Payment payment = new Payment(id,null);
        return new CommonResult(445,"blockHandler sentinel限流，无此流水：blockException: "+e.getMessage(),payment);
    }

    //**********openFeign***************
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSqlId(@PathVariable("id")Long id){

        return paymentService.paymentSqlId(id);
    }

}
