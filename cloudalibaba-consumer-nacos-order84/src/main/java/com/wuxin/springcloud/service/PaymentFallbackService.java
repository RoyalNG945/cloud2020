package com.wuxin.springcloud.service;

import com.wuxin.springcloud.entities.CommonResult;
import com.wuxin.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author Emma Watson
 * @create 2020-05-11 10:46
 */
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSqlId(Long id) {
        return new CommonResult<>(444,"服务降级返回 ---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}
