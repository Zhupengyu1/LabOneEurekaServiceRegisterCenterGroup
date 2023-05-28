package org.example.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.example.entity.CommonResult;
import org.example.entity.User;
import org.example.feign.UserFeignService;
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

    @CircuitBreaker(name="A",fallbackMethod = "fallback")
    @GetMapping("/hello")
    public String hello(){
        return userFeignService.hello();
    }

//    @CircuitBreaker(name="B",fallbackMethod = "fallback")
//    @Bulkhead(name = "C",fallbackMethod = "fallback",type = Bulkhead.Type.THREADPOOL)
    @RateLimiter(name = "D",fallbackMethod = "fallback")
    @GetMapping("/addCart/{userId}")
    public CommonResult<User> addCart(@PathVariable Integer userId)throws InterruptedException{
        System.out.println("进入方法");
//        Thread.sleep(10000L);//阻塞10秒
        System.out.println("服务");
        CommonResult<User> result =userFeignService.addCart(userId);
        System.out.println("离开方法");
        return result;
    }


    public CommonResult<User> fallback(Integer userId, Throwable e){
//        e.printStackTrace();
        System.out.println("fallback已经调用！");
        CommonResult<User> result =new CommonResult<>(400,"当前用户服务不正常，请稍后再试！",new User());
        return result;
    }


}
