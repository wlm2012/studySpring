package com.study.utils;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class bigDecimalTest {

    @Test
    void test() {
        String StrBd = "0.000000000000";
        BigDecimal bigDecimal = new BigDecimal(StrBd);
        bigDecimal = bigDecimal.setScale(2, RoundingMode.DOWN);
        System.out.println("bigDecimal = " + bigDecimal);
    }

    @Test
    void test1() {
        String StrBd = "10485700000000000006.1054";
        System.out.println("bigDecimal = " + new BigDecimal("0.000000000000"));
    }
}