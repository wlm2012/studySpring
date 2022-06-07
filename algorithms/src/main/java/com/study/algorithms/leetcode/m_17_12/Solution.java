package com.study.algorithms.leetcode.m_17_12;

class Solution {

    TreeNode minNode;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        //遍历右子树
        convertBiNode(root.right);
        //遍历根节点
//        System.out.println(root.val);
        root.right = minNode;
        minNode = root;
        //遍历左子树
        convertBiNode(root.left);
        //置空左指针
        root.left = null;
        return minNode;
    }
}

