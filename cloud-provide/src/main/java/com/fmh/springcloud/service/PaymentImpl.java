package com.fmh.springcloud.service;

import com.fmh.springcloud.dao.PaymentMapper;
import com.fmh.springcloud.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment queryById(Long id) {
        return paymentDao.queryById(id);
    }
}
