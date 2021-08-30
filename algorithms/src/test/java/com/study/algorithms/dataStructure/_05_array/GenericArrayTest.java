package com.study.algorithms.dataStructure._05_array;

import org.junit.jupiter.api.Test;

public class GenericArrayTest {

    @Test
    public void arrayTest() {
        GenericArray<Integer> array = new GenericArray<>();
        System.out.println(array.get(6));
        System.out.println(array.get(996));
    }




}
