package com.study.algorithms.leetcode.m_01_05;

class Solution {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        char[] firsts = first.toCharArray();
        char[] seconds = second.toCharArray();

        if (first.length() == second.length()) {
            int index = 0;
            for (int i = 0; i < firsts.length; i++) {
                if (firsts[i] != seconds[i]) {
                    index++;
                    if (index > 1) {
                        return false;
                    }
                }
            }
            return true;
        }

        if (firsts.length > seconds.length) {
            return oneInsert(firsts, seconds);
        } else {
            return oneInsert(seconds, firsts);
        }
    }

    private boolean oneInsert(char[] longer, char[] shorter) {
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < longer.length; i++) {
            if (index2 + 1 > shorter.length || longer[index1] != shorter[index2]) {
                index1++;
            } else {
                index1++;
                index2++;
            }
            if (index1 - index2 > 1) {
                return false;
            }
        }
        return true;
    }
}
