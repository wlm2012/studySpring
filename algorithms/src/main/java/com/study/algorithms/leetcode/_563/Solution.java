package com.study.algorithms.leetcode._563;

public class Solution {
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int num = cut(root);
        if (root.left != null) {
            num += findTilt(root.left);
        }
        if (root.right != null) {
            num += findTilt(root.right);
        }
        return num;
    }

    public int sum(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int result = treeNode.val;
        if (treeNode.left != null) {
            result += sum(treeNode.left);
        }
        if (treeNode.right != null) {
            result += sum(treeNode.right);
        }
        return result;
    }

    public int cut(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = treeNode.left != null ? sum(treeNode.left) : 0;
        int right = treeNode.right != null ? sum(treeNode.right) : 0;
        return Math.abs(left - right);
    }
}
