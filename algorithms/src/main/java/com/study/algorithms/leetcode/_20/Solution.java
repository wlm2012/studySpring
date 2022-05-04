package com.study.algorithms.leetcode._20;

import java.util.*;

public class Solution {

    public boolean isValid(String s) {
//        '('，')'，'{'，'}'，'['，']'
        if (s.length() % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        LinkedList<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (Character ch : chars) {
            if (map.containsKey(ch)) {
                if (list.isEmpty() || list.peek() != map.get(ch)) {
                    return false;
                }
                list.pop();
            } else {
                list.push(ch);
            }
        }

        return list.isEmpty();
    }
}
