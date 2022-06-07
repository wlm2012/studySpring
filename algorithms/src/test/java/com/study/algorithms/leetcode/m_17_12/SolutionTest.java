package com.study.algorithms.leetcode.m_17_12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void should_return_linkded_list() {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.left.left.left = new TreeNode(0);
        treeNode.right.right=new TreeNode(6);
        Solution solution = new Solution();
        solution.convertBiNode(treeNode);
    }

}