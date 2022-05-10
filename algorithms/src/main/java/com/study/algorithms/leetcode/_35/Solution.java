package com.study.algorithms.leetcode._35;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (tail >= head) {
            int now = (head + tail) / 2;
            if (target > nums[now]) {
                head = now + 1;
            } else {
                tail = now - 1;
            }
        }
        return head;
    }
}