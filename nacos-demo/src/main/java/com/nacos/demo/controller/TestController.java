package com.nacos.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RestController
@RequestMapping("/nacos")
public class TestController {

    @Value("${spring.redis.host:mysqlLocal}") //给一个默认值，如果没有找到输出local
    private String ceshi;

    @GetMapping("/test")
    public String test(){
        return ceshi;
    }

    @Autowired
    LoadBalancerClient loadBalancerClient;

    private String serviceId="nacos‐restful‐provider";

    @GetMapping(value = "/service")
    public String service(){
        RestTemplate restTemplate = new RestTemplate();
        //调用服务
        //String providerResult = restTemplate.getForObject("http://" + providerAddress +  "/service",String.class);
        ServiceInstance serviceInstance = loadBalancerClient.choose(serviceId);
        URI uri = serviceInstance.getUri();
        String providerResult = restTemplate.getForObject(uri+"/service",String.class);
        return  providerResult;
    }
}
