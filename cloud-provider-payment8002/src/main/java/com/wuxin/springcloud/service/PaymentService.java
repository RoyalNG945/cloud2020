package com.wuxin.springcloud.service;


import com.wuxin.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getById(Long id);

}
