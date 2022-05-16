package com.study.algorithms.leetcode._705;

import java.util.LinkedList;

class MyHashSet {
    private static final int BASE = 769;
    private static LinkedList<Integer>[] data;

    public MyHashSet() {
        data = new LinkedList<>[BASE];
        for (int i = 0; i < data.length; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int hash = hash(key);
        data[hash].add(key);
    }

    public void remove(int key) {
        if (!contains(key)){
            return;
        }
        int hash = hash(key);
        data[hash].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int hash = hash(key);
        for (Integer integer : data[hash]) {
            if (integer == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % BASE;
    }
}