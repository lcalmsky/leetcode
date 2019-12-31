package io.lcalmsky.leetcode.binary_tree_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> orders = new ArrayList<>();
        List<Integer> order;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        treeNodeQueue.offer(root);
        levelQueue.offer(1);

        TreeNode node;
        int level;
        while (!treeNodeQueue.isEmpty()) {
            node = treeNodeQueue.poll();
            level = levelQueue.poll();
            if (orders.size() < level) {
                order = new ArrayList<>();
                orders.add(order);
            } else order = orders.get(orders.size() - 1);
            order.add(node.val);
            if (node.left != null) {
                treeNodeQueue.offer(node.left);
                levelQueue.offer(level + 1);
            }
            if (node.right != null) {
                treeNodeQueue.offer(node.right);
                levelQueue.offer(level + 1);
            }
        }

        return orders;
    }
}