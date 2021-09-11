package com.study.utils.config;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class RestTemplateConfig {

    private static final int HTTP_MAX_IDLE = 2;
    private static final int HTTP_KEEP_ALIVE = 20;
    private static final int HTTP_CONNECTION_TIMEOUT = 30;

    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(HTTP_CONNECTION_TIMEOUT * 1000);
        requestFactory.setConnectTimeout(HTTP_CONNECTION_TIMEOUT * 1000);
        return new RestTemplate(requestFactory);
    }

    @Bean
    public RestTemplate okhttpRestTemplate() {
        ConnectionPool pool = new ConnectionPool(HTTP_MAX_IDLE, HTTP_KEEP_ALIVE, TimeUnit.SECONDS);
        OkHttpClient builder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .connectionPool(pool)
                .connectTimeout(HTTP_CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .build();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(new OkHttp3ClientHttpRequestFactory(builder));
        return restTemplate;

    }

}
