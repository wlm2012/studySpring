package com.study.algorithms.leetcode._5;


class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int j = 0;
        Result result = new Result(0, 0, 0);
        for (int i = 0; i < chars.length; i++) {
            //偏移量
            int k = 0;
            while (i - k - 1 >= 0 && i + k + 1 < chars.length) {
                if (chars[i - k - 1] != chars[i + k + 1]) {
                    break;
                }
                k++;
            }
            if (k > 0) {
                Result result1 = new Result(i, k, j);
                if (result1.output() > result.output()) {
                    result = result1;
                }
            }

            j = 1;
            k = 0;
            while (i - k + j - 1 >= 0 && i + k + 1 < chars.length && i - k + j - 1 < chars.length) {
                if (chars[i - k + j - 1] != chars[i + k + 1]) {
                    break;
                }
                k++;
            }
            if (k > 0) {
                Result result1 = new Result(i, k, j);
                if (result1.output() > result.output()) {
                    result = result1;
                }
            }
            j = 0;
        }
        if (result.output() == 0) {
            return "";
        }

        char[] chars1 = new char[result.length()];
        System.arraycopy(chars, result.src(), chars1, 0, result.length());
        return new String(chars1);
    }


    static class Result {
        private final int i;
        private final int k;
        private final int j;

        public Result(int i, int k, int j) {
            this.i = i;
            this.k = k;
            this.j = j;
        }

        public int output() {
            return 2 * k + (j == 0 ? 1 : 0);
        }

        public int src() {
            return i - k + j;
        }

        public int pos() {
            return i + k;
        }

        public int length() {
            return pos() - src() + 1;
        }
    }
}
