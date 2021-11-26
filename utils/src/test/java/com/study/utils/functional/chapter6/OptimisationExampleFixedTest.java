package com.study.utils.functional.chapter6;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@Slf4j
@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@Fork(1)
@Threads(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 1)
@Measurement(iterations = 5)
public class OptimisationExampleFixedTest {

    @Test
    public void test() throws RunnerException {
        Options build = new OptionsBuilder()
                .include(OptimisationExampleFixedTest.class.getSimpleName())
                .build();
        new Runner(build).run();
    }

    @Benchmark
    public void slowSumOfSquares(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares(OptimisationExampleFixed.init()));
    }

    @Benchmark
    public void slowSumOfSquares1(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares1(OptimisationExampleFixed.init()));
    }

    @Benchmark
    public void slowSumOfSquares2(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares2(OptimisationExampleFixed.init()));
    }

    @Benchmark
    public void slowSumOfSquares3(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares3(OptimisationExampleFixed.init()));
    }

    @Benchmark
    public void slowSumOfSquares4(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares(OptimisationExampleFixed.init1()));
    }

    @Benchmark
    public void slowSumOfSquares5(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares1(OptimisationExampleFixed.init1()));
    }

    @Benchmark
    public void slowSumOfSquares6(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares2(OptimisationExampleFixed.init1()));
    }

    @Benchmark
    public void slowSumOfSquares7(Blackhole blackhole) {
        blackhole.consume(OptimisationExampleFixed.slowSumOfSquares3(OptimisationExampleFixed.init1()));
    }

}
