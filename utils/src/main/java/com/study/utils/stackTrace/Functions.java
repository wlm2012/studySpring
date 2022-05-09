package com.study.utils.stackTrace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Functions {

    public void test() {
        log.info("begin");
        LogClazz.info();
        log.info("end");
    }
}
