package com.wuxin.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author Emma Watson
 * @create 2020-05-10 11:27
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA(){
        log.info(Thread.currentThread().getName()+"....testA");
        return "******testA*******";
    }

    @GetMapping(value = "/testB")
    public String testB(){
        return "******testB*******";
    }

    @GetMapping(value = "/testD")
    public String testD(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT 平均响应时长");
        return "******testD*******";
    }


    @GetMapping(value = "/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "deal_testHotkey")
    public String testHotkey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){
        return "*****testHotkey******";
    }

    public String deal_testHotkey(String p1, String p2, BlockException exception){
        return "*****deal_testHotkey****** /(ㄒoㄒ)/~~";
    }

}
