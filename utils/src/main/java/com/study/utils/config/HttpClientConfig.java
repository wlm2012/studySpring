package com.study.utils.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.http.HttpClient;
import java.time.Duration;
import java.util.concurrent.*;

@Configuration
public class HttpClientConfig {

    @Bean
    public HttpClient java11Http() {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);
        ExecutorService service = new ThreadPoolExecutor(10, 12, 30, TimeUnit.SECONDS, queue);

        return HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .connectTimeout(Duration.ofSeconds(30))
                .executor(service)
                .build();
    }
}
