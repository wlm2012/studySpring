package com.study.algorithms.leetcode._11;

public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int first = height[0];
        for (int i = 0; i < height.length; i++) {
            int after = height[height.length - 1];
            if (first > height[i]) {
                continue;
            } else {
                first = height[i];
            }
            for (int j = height.length - 1; j > i; j--) {
                if (after > height[j]) {
                    continue;
                } else {
                    after = height[j];
                }
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            }
        }
        return max;
    }

    public int maxArea1(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (right > left) {
            int heightRight = height[right];
            int heightLeft = height[left];
            max = Math.max(Math.min(heightLeft, heightRight) * (right - left), max);
            if (heightRight > heightLeft) {
                left++;
                while (height[left] < heightLeft) {
                    left++;
                    if (left >= right) {
                        return max;
                    }
                }

            } else {
                right--;
                while (height[right] < heightRight) {
                    right--;
                    if (left >= right) {
                        return max;
                    }
                }
            }
        }
        return max;
    }

}
