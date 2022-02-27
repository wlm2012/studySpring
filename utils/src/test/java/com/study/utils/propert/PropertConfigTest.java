package com.study.utils.propert;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertConfigTest {

    @Resource
    private PropertConfig propertConfig;

    @Test
    void test() {
        System.out.println(propertConfig);
        assertEquals(1,propertConfig.getId());
        assertEquals("qqq",propertConfig.getName());
        System.out.println(propertConfig.getBooks());
        System.out.println(propertConfig.getGoods());
    }

}