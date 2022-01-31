package com.study.algorithms.leetcode._1342;

class Solution {
    public int numberOfSteps(int num) {
        int result = 0;
        while (num > 0) {
            if (num % 2 == 1) {
                num--;
            } else {
                num >>= 1;
            }
            result++;

        }
        return result;
    }
}