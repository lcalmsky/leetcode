package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> values = new ArrayList<>();

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(root);

        TreeNode top;
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                top = treeNodeQueue.poll();
                if (i == 0) values.add(top.val);
                if (top.right != null) treeNodeQueue.add(top.right);
                if (top.left != null) treeNodeQueue.add(top.left);
            }
        }

        return values;
    }
}