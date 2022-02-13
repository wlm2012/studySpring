package com.study.algorithms.leetcode._1189;

class Solution {
    public int maxNumberOfBalloons(String text) {
        int length = text.length();
        int b = 0;
        int a = 0;
        int l = 0;
        int o = 0;
        int n = 0;

        for (int i = 0; i < length; i++) {
            char c = text.charAt(i);
            switch (c) {
                case 'b' -> b++;
                case 'a' -> a++;
                case 'l' -> l++;
                case 'o' -> o++;
                case 'n' -> n++;
            }
        }

        return Math.min(b, Math.min(a, Math.min(n, Math.min(l / 2, o / 2))));

    }
}