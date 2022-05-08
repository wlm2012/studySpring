package com.study.algorithms.leetcode._28;

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || haystack.length() == 0) {
            return 0;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        int result = -1;
        char[] chars = haystack.toCharArray();
        char[] need = needle.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (compare(chars, i, need)) {
                return i;
            }
        }
        return -1;
    }

    private boolean compare(char[] haystack, int i, char[] needle) {
        if (needle.length > haystack.length - i) {
            return false;
        }
        for (int j = 0; j < needle.length; j++) {
            if (needle[j] != haystack[j + i]) {
                return false;
            }
        }
        return true;
    }

}
