package com.fmh.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> {
    private Integer code;

    private T data;

    private String message;

    public Result(Integer code, String message) {
        this(code, null, message);
    }
}
