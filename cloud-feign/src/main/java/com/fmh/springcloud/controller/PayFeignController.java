package com.fmh.springcloud.controller;

import com.fmh.springcloud.pojo.Payment;
import com.fmh.springcloud.pojo.Result;
import com.fmh.springcloud.service.PayService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pay")
public class PayFeignController {

    @Resource
    private PayService payService;

    @PostMapping("/create")
    public Result<Integer> create(Payment payment) {
        return payService.create(payment);
    }

    @GetMapping("/get/{id}")
    public Result<Payment> getPayment(@PathVariable("id") Long id) {
        return payService.queryById(id);
    }
}
