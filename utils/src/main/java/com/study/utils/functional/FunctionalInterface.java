package com.study.utils.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterface {

    public static void consumer() {
        Consumer<String> consumer1 = s -> System.out.println(s + " consumer1");
        Consumer<String> consumer2 = s -> System.out.println(s + " consumer2");

        consumer1.andThen(consumer2).accept("test");
    }

    public static void supplier() {
        Supplier<String> supplier = () -> "supplier ";
        System.out.println(supplier.get());
    }

    public static void function1() {
        Function<Integer, Integer> function = e -> e * 2;
        System.out.println(function.apply(3));
    }

    public static void function2() {
        Function<>
    }


}
