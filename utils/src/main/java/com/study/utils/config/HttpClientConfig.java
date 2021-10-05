package com.study.utils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.concurrent.*;

@Configuration
public class HttpClientConfig {

    @Bean
    public java.net.http.HttpClient java11Http() {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        ExecutorService service = new ThreadPoolExecutor(1, 2, 30, TimeUnit.SECONDS, queue);

        return java.net.http.HttpClient.newBuilder()
                .version(java.net.http.HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(30))
                .executor(service)
                .build();

    }
}
