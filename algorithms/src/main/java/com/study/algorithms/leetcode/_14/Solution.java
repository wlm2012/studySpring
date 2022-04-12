package com.study.algorithms.leetcode._14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        char[] chars = strs[0].toCharArray();
        int num = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (num == 0) {
                return "";
            }

            char[] chars1 = strs[i].toCharArray();
            num=Math.min(num,strs[i].length());
            for (int j = 0; j < num; j++) {
                if (chars[j] != chars1[j]) {
                    num = j;
                    break;
                }
            }

        }
        return String.valueOf(chars, 0, num);
    }
}
