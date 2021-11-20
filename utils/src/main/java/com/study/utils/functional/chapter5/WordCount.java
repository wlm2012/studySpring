package com.study.utils.functional.chapter5;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {

    public Map<String, Long> countWords(Stream<String> words) {
        return words.collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }
}
