package com.study.utils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class UtilsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UtilsApplication.class, args);

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
