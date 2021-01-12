package io.lcalmsky.leetcode.binary_tree_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = root;
        List<Integer> result = new ArrayList<>();
        TreeNode node;
        while (!nodes.isEmpty() || current != null) {
            if (current != null) {
                nodes.push(current);
                current = current.left;
            } else {
                node = nodes.pop();
                result.add(node.val);
                current = node.right;
            }
        }

        return result;
    }
}
