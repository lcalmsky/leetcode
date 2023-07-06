package io.lcalmsky.leetcode.lowest_common_ancestor_of_a_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

import java.util.Optional;

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return Optional.ofNullable(left).orElse(right);
    }
}