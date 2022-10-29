package com.study.utils.concurrency.asynProgramming._2;

public class SyncExample {
    public static void doSomethingA() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- doSomethingA---");
    }

    public static void doSomethingB() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- doSomethingB---");
    }

    public static String returnA() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- returnA---");
        return "A task is done";
    }

    public static String returnB() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--- returnB---");
        return "B task is done";
    }
}