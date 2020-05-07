package com.wuxin.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Emma Watson
 * @create 2020-05-07 9:57
 */
@Component
public class PaymentHystrixServiceFallback implements PaymentHystrixService {

    @Override
    public String paymentInfo_Ok(Integer id) {
        return "===PaymentHystrixServiceFallback#paymentInfo_Ok Fallback /(ㄒoㄒ)/~~";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "===PaymentHystrixServiceFallback#paymentInfo_Timeout Fallback /(ㄒoㄒ)/~~";
    }
}
