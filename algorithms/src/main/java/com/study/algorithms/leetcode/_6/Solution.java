package com.study.algorithms.leetcode._6;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public String convert(String s, int numRows) {

        if (numRows==1){
            return s;
        }
        TreeMap<Integer, Character> map = new TreeMap<>();
        char[] chars = s.toCharArray();
        int lie = 1;
        int hang = 1;
        boolean fangxiang = true;
        map.put(lie * 1000 + hang, chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (fangxiang) {
                lie++;
                if (lie >= numRows) {
                    fangxiang = false;
                }
            } else {
                lie--;
                hang++;
                if (lie <= 1) {
                    fangxiang = true;
                }
            }
            map.put(lie * 1000 + hang, chars[i]);
        }

        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Character> entry : map.entrySet()) {
            result.append(entry.getValue());
        }
        return result.toString();
    }
}