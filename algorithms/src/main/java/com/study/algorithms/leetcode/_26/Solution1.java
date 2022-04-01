package com.study.algorithms.leetcode._26;

public class Solution1 {
    public int removeDuplicates(int[] nums) {
        int fast = 1;
        int slow = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
