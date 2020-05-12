package com.wuxin.springcloud.service.impl;

import com.wuxin.springcloud.dao.StorageDao;
import com.wuxin.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Emma Watson
 * @create 2020-05-11 21:49
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService{

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);
    @Resource
    private StorageDao storageDao;


    @Override
    public void decrease(Long productId, Integer count) {
        log.info("*********storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        log.info("*********storage-service中扣减库存结束");
    }
}
