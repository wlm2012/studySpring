package com.study.algorithms.leetcode._942;

class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ints = new int[n + 1];
        int min = 0;
        int max = n;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] == 'I' ? min++ : max--;
        }
        ints[n] = min;

        return ints;
    }
}
