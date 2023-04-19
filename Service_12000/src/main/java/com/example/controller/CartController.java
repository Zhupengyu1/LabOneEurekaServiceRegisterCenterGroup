package com.example.controller;

import com.example.entity.CommonResult;
import com.example.entity.User;
import com.example.feign.UserFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-03-08 15:00
 */
@RestController
@RequestMapping("/cart")
public class CartController {


    @Autowired
    private UserFeignService userFeignService;


    @GetMapping("/hello")
    public String hello(){
        return userFeignService.hello();
    }

    @GetMapping("/addCart/{userId}")
    public CommonResult<User> addCart(@PathVariable Integer userId)throws InterruptedException{
        System.out.println("进入方法");
        CommonResult<User> list = userFeignService.addCart(userId);
        System.out.println("离开方法");
        return list;
    }

}
