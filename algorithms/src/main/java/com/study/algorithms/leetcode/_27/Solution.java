package com.study.algorithms.leetcode._27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;
        while (tail >= head) {
            while (nums[tail] == val) {
                tail--;
                if (tail < 0) {
                    return 0;
                }
            }
            if (head >= tail) {
                break;
            }
            if (nums[head] == val) {
                nums[head] = nums[tail];
                tail--;
            }
            head++;
        }
        return tail + 1;
    }
}
