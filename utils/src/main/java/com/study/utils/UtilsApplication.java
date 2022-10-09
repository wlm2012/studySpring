package com.study.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

//@EnableScheduling
@SpringBootApplication
public class UtilsApplication {

//    @Resource
//    private static RestTemplate okhttpRestTemplate;

    public static void main(String[] args) {
        SpringApplication.run(UtilsApplication.class, args);

//        String forObject = okhttpRestTemplate.getForObject("https://www.baidu.com", String.class);
//        System.out.println(forObject);

/*        int i = 0;
        while (i < 100) {
            i++;
            try {
                System.out.println("sleep  " + i);
                Thread.sleep(1_000_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }

}
