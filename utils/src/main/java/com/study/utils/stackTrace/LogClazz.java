package com.study.utils.stackTrace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogClazz {

    public static void info() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            log.info(stackTraceElement.toString());
        }
    }
}
