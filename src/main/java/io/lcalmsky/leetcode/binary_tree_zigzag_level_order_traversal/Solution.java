package io.lcalmsky.leetcode.binary_tree_zigzag_level_order_traversal;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> orders = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> order;
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            order = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.remove();
                if (level % 2 == 1) {
                    order.add(poll.val);
                } else {
                    order.add(0, poll.val);
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            orders.add(order);
            level++;
        }
        return orders;
    }
}
