package com.study.algorithms.leetcode._69;

class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long mid = (left + x) / 2;
        while (!((mid * mid) <= x && ((mid + 1) * (mid + 1)) > x)) {
            if ((mid * mid) < x) {
                left = mid + 1;
                mid = (right + left) / 2;
            } else {
                right = mid - 1;
                mid = (left + left) / 2;
            }
        }
        return (int) mid;
    }
}