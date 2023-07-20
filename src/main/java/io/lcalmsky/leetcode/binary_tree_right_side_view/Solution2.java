package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private void rightSideView(TreeNode node, List<Integer> result, int depth) {
        if (node == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(node.val);
        }
        rightSideView(node.right, result, depth + 1);
        rightSideView(node.left, result, depth + 1);
    }
}