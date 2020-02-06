package io.lcalmsky.leetcode.count_complete_tree_nodes;

import io.lcalmsky.leetcode.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
