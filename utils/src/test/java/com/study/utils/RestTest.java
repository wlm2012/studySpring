package com.study.utils;

import com.google.gson.Gson;
import com.study.utils.VO.ImgRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@SpringBootTest
public class RestTest {

    @Resource
    private RestTemplate okhttpRestTemplate;

    @Resource
    private HttpClient httpClient;

    @Test
    public void restTest() throws IOException {
        ImgRequest imgRequest = ImgRequest.builder().ckyt("yes").fjmc("身份证")
                .lsh("01994b0c523d4ba49b9e47a57b7775b8")
                .url("http://10.10.60.62:8015/files/images/wx2021.jpg")
                .xh("1")
                .build();
        String url = "http://10.10.60.62:8015/api/get_img2";
   /*     Gson gson = new Gson();
        String json = gson.toJson(imgRequest);
        byte[] result = HttpUtil.postStr(url, json);
        byte[] bytes=new byte[result.length-10];
        System.arraycopy(result,10,bytes,0,result.length-10);

        byte[] num=new byte[10];
        System.arraycopy(result,0,num,0,10);
        log.info(String.valueOf(bytes.length));
        ByteArrayOutputStream out =  new ByteArrayOutputStream();
        out.write(num);
        log.info(out.toString());
        FilesUtils.createFile("D:\\1.jpg", bytes);*/
        Gson gson = new Gson();
        String json = gson.toJson(imgRequest);
        String result = HttpUtil.post(url, json);
        log.info(result.substring(0, 10));
        result = result.substring(10);
        log.info(String.valueOf(result.length()));
        FilesUtils.createFile("D:\\1.jpg", result.getBytes());

/*        ResponseEntity<String> response = okhttpRestTemplate.postForEntity(url, imgRequest, String.class);
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            String result = response.getBody();
            log.info(result);
            result = result.substring(10);
            FilesUtils.createFile("D:\\1.jpg", result.getBytes());
        }*/
    }

    @Test
    public void java11httpTest() throws ExecutionException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("http://www.baidu.com"))
                .GET()
                .build();
        CompletableFuture<HttpResponse<String>> completableFuture = httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString());
        String s = completableFuture.thenApply(HttpResponse::body).get();
        System.out.println(s);

    }

}
