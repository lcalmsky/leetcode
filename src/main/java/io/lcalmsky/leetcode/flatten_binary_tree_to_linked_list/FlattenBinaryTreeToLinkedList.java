package io.lcalmsky.leetcode.flatten_binary_tree_to_linked_list;

import io.lcalmsky.leetcode.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        Stack<TreeNode> treeNodes = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodes.empty()) {
            if (node.right != null) treeNodes.push(node.right);
            if (node.left != null) {
                node.right = node.left;
                node.left = null;
            } else if (!treeNodes.empty()) node.right = treeNodes.pop();
            node = node.right;
        }
    }
}