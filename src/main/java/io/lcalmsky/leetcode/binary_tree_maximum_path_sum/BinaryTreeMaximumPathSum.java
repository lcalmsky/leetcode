package io.lcalmsky.leetcode.binary_tree_maximum_path_sum;

import io.lcalmsky.leetcode.TreeNode;

public class BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }

    private int maxPathSum(TreeNode root, int[] max) {
        if (root == null) return 0;
        int left = maxPathSum(root.left, max);
        int right = maxPathSum(root.right, max);
        int current = Math.max(root.val, Math.max(root.val + left, root.val + right));
        max[0] = Math.max(max[0], Math.max(current, left + root.val + right));
        return current;
    }
}