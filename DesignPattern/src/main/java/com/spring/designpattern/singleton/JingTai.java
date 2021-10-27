package com.spring.designpattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

public class JingTai {
    private static final AtomicLong id = new AtomicLong(0);

    private JingTai() {
    }

    private static class SingletonHolder {
        private static final JingTai instance = new JingTai();
    }

    public static JingTai getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
