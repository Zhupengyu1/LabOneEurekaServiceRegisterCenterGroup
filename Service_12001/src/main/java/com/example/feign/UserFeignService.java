package com.example.feign;

import com.example.entity.CommonResult;
import com.example.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-03-22 15:34
 */
//OpenFeign代替restTemplate
@FeignClient("provider-server")//声明调用的服务
public interface UserFeignService {
    @GetMapping("/user/getUserById/{userId}")
    CommonResult<User> addCart(@PathVariable("userId") Integer userId);//OpenFeign不可省略


    @GetMapping("/user/hello")
    String hello();

}
