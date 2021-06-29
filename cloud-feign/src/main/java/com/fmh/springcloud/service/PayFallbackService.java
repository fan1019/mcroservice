package com.fmh.springcloud.service;

import com.fmh.springcloud.pojo.Payment;
import com.fmh.springcloud.pojo.Result;
import org.springframework.stereotype.Component;


@Component
public class PayFallbackService implements PayService{
    @Override
    public Result<Integer> create(Payment payment) {
        return new Result<>(400,1,"失败");
    }

    @Override
    public Result<Payment> queryById(Long id) {
        return new Result<>(444,"失败");
    }
}
