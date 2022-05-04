package com.study.algorithms.leetcode._1305;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Solution {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayBlockingQueue<TreeNode> queue1 = new ArrayBlockingQueue<>(30000);
        ArrayBlockingQueue<TreeNode> queue2 = new ArrayBlockingQueue<>(30000);
        ArrayList<Integer> list1 = new ArrayList<>(30000);
        ArrayList<Integer> list2 = new ArrayList<>(30000);
        return new ArrayList<>();
    }


/*    1、一直查询左树，直到为null（可能没有左树，或者值为null），如果找到的左树不为null，则把树压入队列中
    2、如果左树为null，则寻找右树，重复步骤1
    3、如果左右树都为null，则弹出队列中的树，尝试查询右树，如果右树不为null，则重复步骤1，如果为null，则重复步骤3
    4、如果是从左树退到父树的，则尝试寻找右树，如果是从右树退回来的，则弹出父树，并*/

    public int sort(TreeNode root, ArrayBlockingQueue<TreeNode> queue, ArrayList<Integer> list) {
        return 0;
    }
}
