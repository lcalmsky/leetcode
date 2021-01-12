package io.lcalmsky.leetcode.binary_tree_preorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        preorder(root, order);
        return order;
    }

    private void preorder(TreeNode root, List<Integer> order) {
        if (root == null) return;
        order.add(root.val);
        preorder(root.left, order);
        preorder(root.right, order);
    }
}
