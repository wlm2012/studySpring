package com.study.utils.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
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
        Function<Integer, Integer> function1 = e -> e * e;
        Function<Integer, Integer> function2 = e -> e * 2;
        System.out.println(function1.compose(function2).apply(3));
        System.out.println(function1.andThen(function2).apply(3));
    }

    public static void predicate1() {
        Predicate<Integer> predicate1 = t -> t > 0;


        Predicate<Integer> predicate2 = t -> t >= 0;

        System.out.println(predicate1.test(1));

        System.out.println(predicate1.and(predicate2).test(0));

        System.out.println(predicate1.or(predicate2).test(0));

        System.out.println(predicate1.test(0));
        System.out.println(predicate1.negate().test(0));
    }




}
