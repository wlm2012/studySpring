package com.study.utils.functional.chapter6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;


public class OptimisationExampleFixed {


    public static List<Integer> init() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntStream.range(0, 10000).forEach(arrayList::add);
        return arrayList;
    }

    public static List<Integer> init1() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        IntStream.range(0, 1000).forEach(linkedList::add);
        return linkedList;
    }

    public static int slowSumOfSquares(List<Integer> lists) {

        return lists.stream().parallel()
                .reduce(0, (acc, x) -> acc + x * x);
    }

    public static int slowSumOfSquares1(List<Integer> lists) {
        int result = 0;
        for (Integer list : lists) {
            result += list * list;
        }
        return result;
    }

    public static int slowSumOfSquares2(List<Integer> lists) {
        return lists.parallelStream()
                .map(x -> x * x)
                .reduce(0, Integer::sum);
    }

    public static int slowSumOfSquares3(List<Integer> lists) {
        return lists.parallelStream()
                .mapToInt(x -> x * x)
                .sum();
    }


}
