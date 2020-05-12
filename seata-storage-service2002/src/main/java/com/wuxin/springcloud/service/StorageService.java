package com.wuxin.springcloud.service;

/**
 * @author Emma Watson
 * @create 2020-05-11 21:48
 */
public interface StorageService {

    void decrease(Long productId,Integer count);
}
