package com.fmh.springcloud.controller;

import com.fmh.springcloud.pojo.Payment;
import com.fmh.springcloud.pojo.Result;
import com.fmh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping("/create")
    public Result<Integer> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("ch");
        if (i > 0) {
            return new Result<>(200, i, "插入成功");
        } else {
            return new Result<>(444, null, "插入失败");
        }
    }

    @GetMapping("/get/{id}")
    public Result<Payment> queryById(@PathVariable("id") Long id) {
        Payment payment = paymentService.queryById(id);
        if (null != payment) {
            return new Result<>(200, payment, "查询成功");
        } else {
            return new Result<>(444, null, "查询失败");
        }
    }
}
