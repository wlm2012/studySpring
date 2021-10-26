package com.spring.designpattern.singleton;

import org.junit.jupiter.api.Test;

public class LanHanTest {

    @Test
    public void test() {
        LanHan instance = LanHan.getInstance();
        long id = instance.getId();
        System.out.println(id);
        LanHan instance1 = LanHan.getInstance();
        System.out.println(instance1 == instance);
    }
}
