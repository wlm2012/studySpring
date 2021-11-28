package com.study.algorithms.dataStructure._06_linkedlist;

import org.junit.jupiter.api.Test;

public class LRUBaseLinkedListTest {

    @Test
    public void test() {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.printAll();

        list.add(4);
        list.printAll();

        list.add(3);
        list.printAll();
    }
}
