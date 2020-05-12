package com.wuxin.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Emma Watson
 * @create 2020-05-11 20:52
 */
@Mapper
public interface StorageDao {

    //扣减库存
    void decrease(@Param("productId")Long productId,@Param("count")Integer count);
}
