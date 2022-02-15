package com.study.algorithms.leetcode._1380;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int[] value : matrix) {
            int b = 0;
            int num = value[0];
            for (int j = 1; j < value.length; j++) {
                if (num > value[j]) {
                    num = value[j];
                    b = j;
                }
            }

            int init = 0;
            for (int[] ints : matrix) {
                if (init == 0 && ints[b] > num) {
                    init++;
                }
            }
            if (init == 0) {
                list.add(num);
            }
        }
        return list;
    }
}