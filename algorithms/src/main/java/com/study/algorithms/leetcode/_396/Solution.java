package com.study.algorithms.leetcode._396;

class Solution {
    public int maxRotateFunction(int[] nums) {
        int max = 0;
        int sum = 0;
        int now = 0;
        for (int i = 0; i < nums.length; i++) {
            max += i * nums[i];
            sum += nums[i];
        }
        now = max;

        for (int i = nums.length - 1; i >= 0; i--) {
            now = now + sum - nums[i] * nums.length;
            max = Math.max(now, max);
        }
        return max;
    }
}