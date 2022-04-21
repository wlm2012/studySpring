package com.study.algorithms.leetcode._824;

class Solution {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            // 'a', 'e', 'i', 'o', 'u'
            if (!s[i].startsWith("a") & !s[i].startsWith("e") & !s[i].startsWith("i")
                    & !s[i].startsWith("o") & !s[i].startsWith("u")
                    & !s[i].startsWith("A") & !s[i].startsWith("E") & !s[i].startsWith("I")
                    & !s[i].startsWith("O") & !s[i].startsWith("U")) {
                char c = s[i].charAt(0);
                s[i] = s[i].substring(1) + c;
            }
            s[i] += "ma";
            for (int j = 0; j < i + 1; j++) {
                s[i] += "a";
            }
        }
        return String.join(" ", s);
    }
}