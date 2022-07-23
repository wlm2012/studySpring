package com.study.mybatisplus.config;


import com.study.mybatisplus.domain.entity.BaseEntity;
import com.study.mybatisplus.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(BaseException.class)
    public BaseEntity<?> baseExceptionHandler(BaseException baseException) {
        return BaseEntity.fail(baseException.getCode(), baseException.getMsg());
    }
}
