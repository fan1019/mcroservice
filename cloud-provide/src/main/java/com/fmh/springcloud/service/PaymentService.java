package com.fmh.springcloud.service;

import com.fmh.springcloud.pojo.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    int create(Payment payment);

    Payment queryById(@Param("id") Long id);
}
