package com.study.algorithms.leetcode._821;

import java.util.ArrayList;

class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-10001);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                list.add(i);
            }
        }
        list.add(10001);
        int[] ints = new int[s.length()];
        int j = 0;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Math.min(Math.abs(list.get(j) - i), Math.abs(list.get(j + 1) - i));
            if (i == list.get(j + 1)) {
                j++;
            }
        }
        return ints;
    }
}
