package com.wuxin.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.wuxin.springcloud.entities.CommonResult;
import org.springframework.stereotype.Component;

/**
 * @author Emma Watson
 * @create 2020-05-10 20:56
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(4444,"按客户自定义，global handlerException-----1");
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(4444,"按客户自定义，global handlerException-----2");
    }

}
