package io.lcalmsky.leetcode.recover_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        inorder(root);
        if (second != null && first != null) {
            int val = second.val;
            second.val = first.val;
            first.val = val;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (pre != null) {
            if (root.val < pre.val) {
                if (first == null) first = pre;
                second = root;
            }
        }
        pre = root;
        inorder(root.right);
    }
}
