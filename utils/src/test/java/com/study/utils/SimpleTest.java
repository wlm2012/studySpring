package com.study.utils;

import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    void testString(){
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
    }

    @Test
    void testString1(){
        String str1 = "hello";
        String str2 = "he" + "llo";
        System.err.println(str1 == str2);
    }
}
