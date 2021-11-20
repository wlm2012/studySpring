package com.study.utils.functional.chapter5;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class LongestNameTest {

    Stream<String> names = Stream.of("John Lennon", "Paul McCartney",
            "George Harrison", "Ringo Starr", "Pete Best", "Stuart Sutcliffe");

    @Test
    public void byCollecting(){
        System.out.println(LongestName.byCollecting(names));
    }

    @Test
    public void byMax(){
        System.out.println(LongestName.byMax(names));
    }

    @Test
    public void byReduce(){
        System.out.println(LongestName.byReduce(names));
    }

}
