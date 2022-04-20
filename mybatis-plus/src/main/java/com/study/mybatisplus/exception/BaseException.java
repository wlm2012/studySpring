package com.study.mybatisplus.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class BaseException extends RuntimeException{

    private int code;
    private String msg;
}
