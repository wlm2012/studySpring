package com.study.utils.property;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PropertyConfigTest {

    @Resource
    private PropertyConfig propertyConfig;

    @Test
    void test() {
        System.out.println(propertyConfig);
        assertEquals(1, propertyConfig.getId());
        assertEquals("qqq", propertyConfig.getName());
        System.out.println(propertyConfig.getBooks());
        System.out.println(propertyConfig.getGoods());
    }

}