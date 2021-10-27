package com.spring.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class EHan {

    private final AtomicLong id = new AtomicLong(0);

    private static EHan instance;

    private EHan() {
    }

    public static EHan getInstance() {
        if (instance == null) {
            synchronized (EHan.class) {
                if (instance == null) {
                    instance = new EHan();
                }
            }
        }
        return instance;
    }

    public long getId() {
        return id.getAndIncrement();
    }
}
