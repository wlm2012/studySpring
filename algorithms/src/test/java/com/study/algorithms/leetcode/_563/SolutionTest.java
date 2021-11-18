package com.study.algorithms.leetcode._563;

import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void findTilt() {
        TreeNode treeNode = new TreeNode(3, new TreeNode(4, new TreeNode(5, null, null), null), null);
        TreeNode root = new TreeNode(1, new TreeNode(2, treeNode, null), null);
        Solution solution = new Solution();
        System.out.println(solution.findTilt(root));

    }
}
