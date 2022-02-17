package com.study.algorithms.leetcode._15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }

        int n = nums.length;

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }

            int third = n - 1;
            for (int j = i + 1; j < n - 1; j++) {
                if (j > i + 1 && nums[j - 1] == nums[j]) {
                    continue;
                }

                for (int k = third; k > j; k--) {
                    third = k;
                    if (k < n - 1 && nums[k + 1] == nums[k]) {
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[k] < 0) {
                        break;
                    }
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        lists.add(List.of(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return lists;
    }
}
