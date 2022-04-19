package com.study.algorithms.leetcode._821;

import java.util.ArrayList;

class Solution {
    public int[] shortestToChar(String s, char c) {
        char[] chars = s.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                list.add(i);
            }
        }
        list.add(Integer.MAX_VALUE);
        int[] ints = new int[s.length()];
        int j = 1;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Math.min(Math.abs(list.get(j) - i), Math.abs(list.get(j + 1) - i));
            if (i == list.get(j)) {
                j++;
            }
        }
        return ints;
    }
}
