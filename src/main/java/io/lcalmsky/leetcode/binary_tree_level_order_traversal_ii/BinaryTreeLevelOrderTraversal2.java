package io.lcalmsky.leetcode.binary_tree_level_order_traversal_ii;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<List<Integer>> orders = new ArrayList<>();
        List<Integer> order;

        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);

        TreeNode node;
        int size;
        while (!treeNodes.isEmpty()) {
            order = new ArrayList<>();
            size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                node = treeNodes.poll();
                order.add(node.val);
                Optional.ofNullable(node.left).ifPresent(treeNodes::offer);
                Optional.ofNullable(node.right).ifPresent(treeNodes::offer);
            }
            orders.add(0, order);
        }

        return orders;
    }
}
