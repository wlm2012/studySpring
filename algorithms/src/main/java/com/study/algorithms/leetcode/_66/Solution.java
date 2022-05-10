package com.study.algorithms.leetcode._66;

class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < digits.length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] ints = new int[digits.length + 1];
        ints[0] = 1;
        return ints;

    }
}
