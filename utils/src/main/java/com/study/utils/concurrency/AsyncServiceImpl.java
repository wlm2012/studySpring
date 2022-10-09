package com.study.utils.concurrency;

import com.study.utils.VO.NurseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class AsyncServiceImpl {

    private final RestTemplate restTemplate;

    @Async
    public CompletableFuture<ResponseEntity<String>> postForEntity(HttpEntity<NurseDto> httpEntity) {
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://weixin01.lyasyewm.cn:9007/nurse/nurseInfo/edit", httpEntity, String.class);
        return CompletableFuture.completedFuture(stringResponseEntity);

    }
}
