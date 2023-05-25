package org.example.controller;


import org.example.entity.CommonResult;
import org.example.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-03-08 14:45
 */
@RestController
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

    @PostMapping("/post")
    public CommonResult post(@RequestBody User user){
        CommonResult<User> result = new CommonResult<>(200,"success(post)",user);
        return result;
    }
    @PutMapping("/put")
    public CommonResult put(@RequestBody User user){
        CommonResult<User> result = new CommonResult<>(200,"success(put)",user);
        return result;
    }
    @DeleteMapping("/delete")
    public CommonResult delete(@RequestBody User user){
        CommonResult<User> result = new CommonResult<>(200,"success(delete)",user);
        return result;
    }
}
