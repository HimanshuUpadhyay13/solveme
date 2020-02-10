package com.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 102. Binary Tree Level Order Traversal
 Medium

 2225

 60

 Add to List

 Share
 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
 3
 / \
 9  20
 /  \
 15   7
 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 */
public class TreeProblem {

    private TreeNode head;

    public List<List<Integer>> levelOrder(TreeNode rootNode) {
        List<List<Integer>> res = new ArrayList<>();
        if (rootNode == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            List<Integer> nodes = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode root = queue.peek();
                if (root.left != null)
                    queue.add(root.left);
                if (root.right != null)
                    queue.add(root.right);
                TreeNode n = queue.poll();
                nodes.add(n.val);
            }
            res.add(nodes);
        }
        return res;
    }

    public static void main(String[] args) {

        TreeProblem problem = new TreeProblem();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(9);
        node.left.left = null;
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.left.right = null;
        node.right.left.left = null;
        node.right.right = new TreeNode(7);
        node.right.right.left = null;
        node.right.right.right = null;
        problem.head = node;
        System.out.println(problem.levelOrder(node));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


