package com.study.algorithms.leetcode._67;

class Solution {
    public String addBinary(String a, String b) {

        int length = a.length() - b.length();
        StringBuilder bBuilder = new StringBuilder(b);
        StringBuilder aBuilder = new StringBuilder(a);
        for (int i = 0; i < Math.abs(length); i++) {
            if (length > 0) {
                bBuilder.insert(0, "0");
            } else {
                aBuilder.insert(0, "0");
            }
        }
        a = aBuilder.toString();
        b = bBuilder.toString();

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int init = 0;
        StringBuilder result = new StringBuilder();
        for (int i = aChars.length - 1; i >= 0; i--) {
            int aInt = Integer.parseInt(String.valueOf(aChars[i]));
            int bInt = Integer.parseInt(String.valueOf(bChars[i]));
            if (init + aInt + bInt == 3) {
                result.insert(0, 1);
                init = 1;
            } else if (init + aInt + bInt == 2) {
                result.insert(0, 0);
                init = 1;
            } else {
                result.insert(0, (init + aInt + bInt));
                init = 0;
            }
        }
        if (init == 1) {
            result.insert(0, 1);
        }
        return result.toString();
    }
}
