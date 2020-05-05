package com.wuxin.springcloud.service;

import com.wuxin.springcloud.entities.CommonResult;
import com.wuxin.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping(value = "/{id}")
    CommonResult<Payment> getById(@PathVariable("id") Long id);

    @GetMapping("/payment/get/port")
    String getPort();
}
