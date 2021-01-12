package io.lcalmsky.leetcode.binary_tree_postorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        traverse(root, order);
        return order;
    }

    private void traverse(TreeNode root, List<Integer> order) {
        if (root == null) return;
        traverse(root.left, order);
        traverse(root.right, order);
        order.add(root.val);
    }
}
