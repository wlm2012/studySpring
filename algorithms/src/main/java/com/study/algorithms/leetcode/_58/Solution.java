package com.study.algorithms.leetcode._58;

class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int space = 0;
        int init = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                init++;
            }
            if (chars[i] == ' ') {
                space++;
                if (init > 0) {
                    return chars.length - i - space;
                }

            }
        }
        return chars.length - space;
    }
}
