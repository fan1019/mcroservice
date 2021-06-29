package com.fmh.springcloud.controller;

import com.fmh.springcloud.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public Result fallback() {
        return new Result(400,"请求失败");
    }
}
