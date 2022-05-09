package com.study.utils.stackTrace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Functions {

    public void test() {
        log.info("begin");
        LogClazz.info();
        log.info("end");
    }

    public void test1() {
        log.info("begin");
        LogClazz.info1();
        log.info("end");
    }
}
