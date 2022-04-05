package com.study.algorithms.leetcode._26;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int init = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] == init) {
                removeNums(nums, i);
                length--;
                i--;
            } else {
                init = nums[i];
            }
        }
        return length;
    }

    public void removeNums(int[] nums, int num) {
        if (nums.length - num >= 0) {
            System.arraycopy(nums, num + 1, nums, num, nums.length - num - 1);
        }
    }



}
