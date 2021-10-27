package com.spring.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public enum MeiJu {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.getAndIncrement();
    }
}
