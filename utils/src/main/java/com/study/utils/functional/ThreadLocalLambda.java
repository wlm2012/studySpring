package com.study.utils.functional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalLambda {

    public static void test(String s) {
        ThreadLocal<DateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat(s));
        String s1 = dateFormat.get().format(new Date());
        System.out.println(s1);
    }

}
