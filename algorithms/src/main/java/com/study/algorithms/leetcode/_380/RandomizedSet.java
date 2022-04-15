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

    private final Map<Integer, Integer> hashMap;
    private final List<Integer> arrayList;
    Random random;

    public RandomizedSet() {
        hashMap = new HashMap<>();
        arrayList = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }
        hashMap.put(val, arrayList.size());
        arrayList.add(val);
        return true;
    }

    public boolean remove(int val) {
        Integer integer = hashMap.get(val);
        if (integer == null) {
            return false;
        }
        Integer last = arrayList.get(arrayList.size() - 1);
        arrayList.set(integer,last);
        arrayList.remove(arrayList.size() - 1);
        hashMap.remove(val);
        hashMap.put(last,integer);
        return true;
    }

    public int getRandom() {
        int i = random.nextInt(arrayList.size());
        return arrayList.get(i);
    }
}


