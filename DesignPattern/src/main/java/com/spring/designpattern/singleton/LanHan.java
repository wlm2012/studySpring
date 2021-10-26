package com.spring.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class LanHan {

    private final AtomicLong id = new AtomicLong(0);

    private static final LanHan instance = new LanHan();

    private LanHan() {
    }

    public static LanHan getInstance() {
        return instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
