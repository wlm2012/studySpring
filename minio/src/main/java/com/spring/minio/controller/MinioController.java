package com.spring.minio.controller;

import io.minio.ListObjectsArgs;
import io.minio.MinioClient;
import io.minio.Result;
import io.minio.messages.Item;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MinioController {

    @Resource
    private MinioClient minioClient;

    @RequestMapping("/list")
    public void listMinio() {
        Iterable<Result<Item>> results = minioClient.listObjects(
                ListObjectsArgs.builder().bucket("330301").build());
        int count = 0;
        for (Result<Item> ignored : results) {
            count++;
        }
        System.out.println(count);

    }
}
