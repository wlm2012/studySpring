package com.study.mybatisplus.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseEntity<T> {
    private int code;
    private String msg;
    private T body;

    public static <T> BaseEntity<?> fail(int code, String msg) {
        return BaseEntity.builder().code(code).msg(msg).build();
    }
}
