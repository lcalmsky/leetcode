package io.lcalmsky.leetcode.invert_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) return;
        swap(root);
        invert(root.left);
        invert(root.right);
    }

    private void swap(TreeNode root) {
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
    }
}
