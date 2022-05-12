package com.study.algorithms.leetcode._944;

class Solution {
    public int minDeletionSize(String[] strs) {
        int result = 0;
        char[][] chars = new char[strs.length][strs[0].length()];
        for (int i = 0; i < strs.length; i++) {
            chars[i] = strs[i].toCharArray();
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if ((int) chars[j - 1][i] > (int) chars[j][i]) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
}