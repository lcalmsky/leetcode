package io.lcalmsky.leetcode.binary_tree_zigzag_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> orders = new ArrayList<>();
        List<Integer> order;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean zigzag = false;
        TreeNode node;
        while (!queue.isEmpty()) {
            order = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (zigzag) order.add(0, node.val);
                else order.add(node.val);
                Optional.ofNullable(node.left).ifPresent(queue::add);
                Optional.ofNullable(node.right).ifPresent(queue::add);
            }
            orders.add(order);
            zigzag = !zigzag;
        }
        return orders;
    }
}