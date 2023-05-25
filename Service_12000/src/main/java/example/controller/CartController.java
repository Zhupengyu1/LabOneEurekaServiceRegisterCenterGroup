package example.controller;

import example.entity.CommonResult;
import example.entity.User;
import feign.Request;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author 朱鹏宇
 * @Description
 * @create 2023-03-08 15:00
 */
@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;
    @GetMapping("/getUserById/{userId}")
    public CommonResult getUserById(@PathVariable("userId") Integer userId){

        //通过服务提供者名（provider-server）获取Eureka Server上的元数据
        List<ServiceInstance> instanceList =
                discoveryClient.getInstances("provider-server");
        //现在，元数据集合中只有一个服务信息
        ServiceInstance instance = instanceList.get(0);

        //使用DiscoveryClient获取元数据，主机地址与端口就可以不硬编码了
        CommonResult result = restTemplate.getForObject("http://"+instance.getHost()+":"+
                instance.getPort()+"/user/getUserById/"+userId, CommonResult.class);
        return result;
    }

    @PostMapping("/post")
    public CommonResult login(@RequestBody  User user){
        //通过服务提供者名（provider-server）获取Eureka Server上的元数据
        List<ServiceInstance> instanceList =
                discoveryClient.getInstances("provider-server");
        //现在，元数据集合中只有一个服务信息
        ServiceInstance instance = instanceList.get(0);
        CommonResult result = restTemplate.postForObject("http://"+instance.getHost()+":"+
                instance.getPort()+"/user/post", user,CommonResult.class);
        return result;
    }

    @DeleteMapping("/delete")
    public CommonResult delete(@RequestBody User user){
        //通过服务提供者名（provider-server）获取Eureka Server上的元数据
        List<ServiceInstance> instanceList =
                discoveryClient.getInstances("provider-server");
        //现在，元数据集合中只有一个服务信息
        ServiceInstance instance = instanceList.get(0);
        HttpEntity<User> entity = new HttpEntity<>(user);
        ResponseEntity<CommonResult> exchange = restTemplate.exchange("http://" + instance.getHost() + ":" +
                instance.getPort() + "/user/delete", HttpMethod.DELETE, entity, CommonResult.class);
        return exchange.getBody();
    }

    @PutMapping("/put")
    public CommonResult put(@RequestBody User user){
        //通过服务提供者名（provider-server）获取Eureka Server上的元数据
        List<ServiceInstance> instanceList =
                discoveryClient.getInstances("provider-server");
        //现在，元数据集合中只有一个服务信息
        ServiceInstance instance = instanceList.get(0);
        HttpEntity<User> entity = new HttpEntity<>(user);
        ResponseEntity<CommonResult> exchange = restTemplate.exchange("http://" + instance.getHost() + ":" +
                instance.getPort() + "/user/put", HttpMethod.PUT, entity, CommonResult.class);
        return exchange.getBody();
    }


}
