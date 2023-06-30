package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> values = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.remove();
                if (i == 0) {
                    values.add(node.val);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return values;
    }
}