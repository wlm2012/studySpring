package com.study.algorithms.leetcode._380;

import java.util.*;

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
class RandomizedSet {

    private final HashMap<Integer, Integer> hashMap;

    private final ArrayList<Integer> arrayList;

    public RandomizedSet() {
        hashMap = new HashMap<>();
        arrayList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }
        arrayList.add(val);
        hashMap.put(val, arrayList.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        Integer integer = hashMap.get(val);
        if (integer == null) {
            return false;
        }
        hashMap.remove(val);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int i = random.nextInt(hashMap.size());
        Integer integer = hashMap.get(i);
        return arrayList.get(integer);
    }
}


