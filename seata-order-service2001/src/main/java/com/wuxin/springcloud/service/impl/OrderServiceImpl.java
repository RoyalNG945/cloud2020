package com.wuxin.springcloud.service.impl;

import com.wuxin.springcloud.dao.OrderDao;
import com.wuxin.springcloud.domain.Order;
import com.wuxin.springcloud.service.AccountService;
import com.wuxin.springcloud.service.OrderService;
import com.wuxin.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Emma Watson
 * @create 2020-05-11 17:38
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "create_order_tx",rollbackFor = Exception.class)
    public void create(Order order) {

        log.info("********开始新建订单");
        //1.新建订单
        orderDao.create(order);

        log.info("********订单微服务开始调用库存，做扣减Count");
        //扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("********订单微服务开始调用库存，做扣减end");

        log.info("********订单微服务开始调用账号，做扣减Money");
        // 扣减账户
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("********订单微服务开始调用账号，做扣减end");

        // 修改订单状态
        log.info("********修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("********修改订单状态结束");

        log.info("********下订单结束了，O(∩_∩)O");
    }
}
