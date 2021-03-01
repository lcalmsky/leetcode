package io.lcalmsky.leetcode.minimum_distance_between_bst_nodes;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    private Integer minDiff = Integer.MAX_VALUE, previous = null;

    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (previous != null) minDiff = Math.min(minDiff, root.val - previous);
        previous = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return minDiff;
    }
}
