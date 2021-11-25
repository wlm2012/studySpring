package com.study.utils.functional.chapter6;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@Threads(4)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class OptimisationExampleFixed {

    public static void main(String[] args) throws RunnerException {
        Options build = new OptionsBuilder()
                .include(OptimisationExampleFixed.class.getSimpleName())
                .build();
        new Runner(build).run();
    }

    @Benchmark
    public void sum(Blackhole blackhole) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntStream.range(0, 10).forEach(arrayList::add);

        blackhole.consume(slowSumOfSquares(arrayList));
    }

    @Benchmark
    public void sum1(Blackhole blackhole) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        IntStream.range(0, 10).forEach(arrayList::add);

        blackhole.consume(slowSumOfSquares1(arrayList));
    }

    public static int slowSumOfSquares1(List<Integer> linkedListOfNumbers) {
        int result = 0;
        for (Integer linkedListOfNumber : linkedListOfNumbers) {
            result += linkedListOfNumber * linkedListOfNumber;
        }
        return result;
    }

    public static int slowSumOfSquares(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream().parallel()
                .reduce(0, (acc, x) -> acc + x * x);
    }


}
