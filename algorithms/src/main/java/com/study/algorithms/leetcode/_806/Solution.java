package com.study.algorithms.leetcode._806;

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int num = 1;
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - 'a';
            if ((length + widths[n]) > 100) {
                num++;
                length = widths[n];
            } else {
                length += widths[n];
            }
        }

        return new int[]{num, length};
    }
}
