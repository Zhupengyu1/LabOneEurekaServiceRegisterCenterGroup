package org.example.controller;

import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-04-26 15:35
 */
@RestController
public class ConsumerServiceFallback {

    @RequestMapping(value = "/fallback",method=RequestMethod.GET)
    public CommonResult GetComResult(){
        return new CommonResult<>(403,"由于CnsumerService异常进行服务降级",new User());
    }

}
