package io.lcalmsky.leetcode.diameter_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getMaxDepth(root);
        return max - 1;
    }

    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);
        max = Math.max(max, 1 + left + right);
        return 1 + Math.max(left, right);
    }
}
