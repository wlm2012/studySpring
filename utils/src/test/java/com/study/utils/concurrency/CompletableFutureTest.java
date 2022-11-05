package com.study.utils.concurrency;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureTest {

    private final int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
            AVALIABLE_PROCESSORS * 2, 1,
            TimeUnit.MINUTES, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());


    @Test
    void completableFutureTest() throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        CompletableFuture<String> future = new CompletableFuture<>();
        threadPoolExecutor.execute(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("----" + Thread.currentThread().getName() + " set future result----");
            future.complete("hello,jiaduo");
        });
        System.out.println("---main thread wait future result---");
        System.out.println(future.get());
//        System.out.println(future.get(1000, TimeUnit.MILLISECONDS));
        System.out.println(System.currentTimeMillis() - start + "---main thread got future result---");
    }

    @Test
    void runAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("over");
        });
        System.out.println(future.get());
        System.out.println(System.currentTimeMillis() - start + "---main thread got future result---");
    }

    @Test
    void supplyAsync() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello,jiaduo";
        });
        System.out.println(future.get());
        System.out.println(System.currentTimeMillis() - start + "---main thread got future result---");
    }

    @Test
    void thenRun() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<Void> twoFuture = oneFuture.thenRun(() -> {
            try {
                System.out.println(System.currentTimeMillis() - start + "---oneFuture got future result---");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("---after oneFuture over doSomething---");
        });
        System.out.println(twoFuture.get());
        System.out.println(System.currentTimeMillis() - start + "---twoFuture got future result---");
    }


    @Test
    void thenAccept() throws ExecutionException, InterruptedException {
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (
                    InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<Void> twoFuture = oneFuture.thenAccept(t -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("---after oneFuture over doSomething---" + t);
        });
        System.out.println(twoFuture.get());
    }

    @Test
    void thenApply() throws ExecutionException, InterruptedException {
        CompletableFuture<String> oneFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (
                    InterruptedException e) {
                e.printStackTrace();
            }
            return "hello";
        });
        CompletableFuture<String> twoFuture = oneFuture.thenApply(t -> {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t + " jiduo";
        });
        System.out.println(twoFuture.get());
    }


    @Test
    void whenComplete() throws InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello,jiaduo";
        });

        future.whenComplete((t, u) -> {
            if (null == u) {
                System.out.println(t);
            } else {
                System.out.println(u.getLocalizedMessage());
            }
        });
        Thread.currentThread().join();
    }


}
