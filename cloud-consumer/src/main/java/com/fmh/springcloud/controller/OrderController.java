package com.fmh.springcloud.controller;

import com.fmh.springcloud.pojo.Payment;
import com.fmh.springcloud.pojo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/pay")
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.provide-service}")
    private String provideUrl;

    @PostMapping("/create")
    public Result<Integer> create(Payment payment) {
        return restTemplate.postForObject(provideUrl + "/create/", payment, Result.class);
    }

    @GetMapping("/get/{id}")
    @CacheResult(cacheKeyMethod = "getCacheKey")
    @HystrixCommand(fallbackMethod = "getPaymentFallback", commandKey = "getPayment")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(provideUrl + "/get/" + id, Result.class);
    }

    public Result<Payment> getPaymentFallback(@PathVariable("id") Long id) {
        return new Result<>(400,"失败");
    }

    public String getCacheKey(Long id){
        return String.valueOf(id);
    }
}
