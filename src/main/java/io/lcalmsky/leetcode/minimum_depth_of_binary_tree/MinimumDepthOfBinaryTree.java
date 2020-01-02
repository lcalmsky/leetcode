package io.lcalmsky.leetcode.minimum_depth_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 1);
    }

    private int minDepth(TreeNode node, int level) {

        if (node.left == null && node.right == null) return level;

        int lDepth = Integer.MAX_VALUE;
        if (node.left != null) lDepth = minDepth(node.left, level + 1);

        int rDepth = Integer.MAX_VALUE;
        if (node.right != null) rDepth = minDepth(node.right, level + 1);

        return Math.min(lDepth, rDepth);
    }
}
