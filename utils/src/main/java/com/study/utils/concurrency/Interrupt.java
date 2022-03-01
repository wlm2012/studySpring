package com.study.utils.concurrency;

public class Interrupt {

    public void test() {
        Runnable r = () -> System.out.println("r");
        Thread thread = new Thread(r);
        thread.interrupt();
        thread.start();
        //注意Thread
//        Thread.sleep(1000);
        System.out.println(thread.isInterrupted());
        System.out.println(thread.getName() + "   " + thread.getState());
    }
}
