package com.spring.jpa.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.jpa.common.ServiceException;
import com.spring.jpa.domain.resp.CommonPageResp;
import com.spring.jpa.domain.resp.CommonResp;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler implements ResponseBodyAdvice<Object> {


    private final ObjectMapper objectMapper;

    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    @SneakyThrows
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType,
                                  @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response) {
        if (body instanceof String) {
            return objectMapper.writeValueAsString(CommonResp.success(body));
        }

        if (body instanceof Page<?>) {
            return CommonPageResp.success((Page<?>) body);
        }

        if (body instanceof CommonResp<?>) {
            return body;
        }

        return CommonResp.success(body);

    }

    @ExceptionHandler(ServiceException.class)
    public CommonResp<?> handleServiceException(ServiceException e) {
        log.error(e.getMessage(), e);
        return CommonResp.fail(e.getMessage());
    }


    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public CommonResp<String> exception(Exception e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return CommonResp.fail(e.getMessage());
    }


}
