package com.study.utils.functional;

import com.study.utils.entity.Artist;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StreamTest {

    @Test
    public void addUp() {
        List<Integer> list = List.of(1, 2, 3, 6);
        int i = StreamQuestion.addUp(list);
        System.out.println(i);
        assertEquals(12, i);
    }

    @Test
    public void getNamesAndOrigins() {
        List<Artist> list = List.of(new Artist("ww", "ll"), new Artist("ll", "ll"));
        System.out.println(StreamQuestion.getNamesAndOrigins(list));
    }
}
