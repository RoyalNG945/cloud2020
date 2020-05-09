package com.wuxin.springcloud.controller;

import com.wuxin.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Emma Watson
 * @create 2020-05-08 16:58
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping(value = "/sendmessage")
    public String sendMessage(){

        return messageProvider.send();
    }
}
