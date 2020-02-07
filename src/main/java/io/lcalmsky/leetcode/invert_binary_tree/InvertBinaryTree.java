package io.lcalmsky.leetcode.invert_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if (root == null) return;
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        invert(root.left);
        invert(root.right);
    }
}
