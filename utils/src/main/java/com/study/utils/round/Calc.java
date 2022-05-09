package com.study.utils.round;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Calc {

    public void test() {
        double d = 114.145;
        d = (double) Math.round(d * 100) / 100;
        System.out.println(d);
    }

    public void test1() {
        double d = 114.145;
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        System.out.println(bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue());
    }

    public void test2() {
        double d = 114.145;
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        System.out.println(df.format(d));
    }
}
