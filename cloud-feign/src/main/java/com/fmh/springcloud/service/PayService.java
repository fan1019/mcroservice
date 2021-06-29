package com.fmh.springcloud.service;

import com.fmh.springcloud.pojo.Payment;
import com.fmh.springcloud.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "provider", fallback = PayFallbackService.class)
public interface PayService {

    @PostMapping("/pay/create")
    Result<Integer> create(@RequestBody Payment payment);

    @GetMapping("/pay/get/{id}")
    Result<Payment> queryById(@PathVariable("id") Long id);
}
