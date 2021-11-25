package com.study.utils.functional.chapter6;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 3)
@Measurement(iterations = 5)
public class OptimisationExampleFixedTest {

    @Test
    public void test() throws RunnerException {
        Options build = new OptionsBuilder()
                .include(OptimisationExampleFixedTest.class.getSimpleName())
                .build();
        new Runner(build).run();
    }

    @Test
    public void bench2(){}




}
