package com.study.algorithms.leetcode._706;

import java.util.LinkedList;

class MyHashMap {

    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private final LinkedList<Pair>[] data;

    public MyHashMap() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<>();
        }
    }

    public void put(int key, int value) {
        int hash = hash(key);
        for (Pair pair : data[hash]) {
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[hash].add(new Pair(key, value));
    }

    public int get(int key) {
        int hash = hash(key);
        for (Pair pair : data[hash]) {
            if (pair.getKey() == key) {
                return pair.getValue();
            }
        }
        return -1;
    }

    public void remove(int key) {
        int hash = hash(key);
        for (int i = 0; i < data[hash].size(); i++) {
            if (data[hash].get(i).getKey() == key) {
                data[hash].remove(i);
                return;
            }
        }
    }

    private int hash(int key) {
        return key % BASE;
    }
}

