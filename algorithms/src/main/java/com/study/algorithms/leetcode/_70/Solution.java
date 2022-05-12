package com.study.algorithms.leetcode._70;

import java.util.HashMap;

class Solution {

    private final HashMap<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        map.put(0, 0);
        map.put(1, 1);
        map.put(2, 2);
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int i = climbStairs(n - 1) + climbStairs(n - 2);
        map.put(n, i);
        return i;
    }
}
