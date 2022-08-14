package com.study.moocwiki.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    private String code;

    private String msg;

    private T data;

    private Long rows;

    private Long total;


    // todo 通用返回继续优化
    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = CommonResult.<T>builder()
                .code("200")
                .msg("success")
                .data(data)
                .build();

        return null;
    }


}
