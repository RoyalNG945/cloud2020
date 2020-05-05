package com.wuxin.springcloud.service.impl;

import com.wuxin.springcloud.dao.PaymentDao;
import com.wuxin.springcloud.entities.Payment;
import com.wuxin.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentDao.getById(id);
    }
}
