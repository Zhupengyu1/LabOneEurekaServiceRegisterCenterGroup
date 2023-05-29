package org.example.controller;

import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-03-08 14:45
 */
@RestController
@RefreshScope
@RequestMapping("/user")
public class UserController {


    @GetMapping("/hello")
    public String hello(){
        return "Hello, World!";
    }

    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> addCart(@PathVariable Integer userId){
        User user = new User(userId,"小明","123456");
        CommonResult<User> result = new CommonResult<>(200,"success(11000)",user);
        return result;
    }
}
