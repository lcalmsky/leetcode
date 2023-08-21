package io.lcalmsky.leetcode.flatten_binary_tree_to_linked_list;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    private TreeNode head = null;

    public void flatten(TreeNode root) {
        if (root != null) {
            reversePreOrder(root);
        }
    }

    private void reversePreOrder(TreeNode node) {
        if (node.right != null) {
            reversePreOrder(node.right);
        }
        if (node.left != null) {
            reversePreOrder(node.left);
        }
        node.left = null;
        node.right = head;
        head = node;
    }
}
