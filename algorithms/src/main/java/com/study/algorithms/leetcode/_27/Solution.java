package com.study.algorithms.leetcode._27;

class Solution {
    public int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;
        while (tail > head) {
            while (nums[tail] == val) {
                tail--;
            }
            if (head >= tail) {
                break;
            }
            if (nums[head] == val) {
                int temp = nums[tail];
                nums[tail] = nums[head];
                nums[head] = temp;
                tail--;
            }
            head++;
        }
        return head == tail ? tail : tail + 1;
    }
}
