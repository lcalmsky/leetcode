package io.lcalmsky.leetcode.binary_tree_right_side_view;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

public class Solution {
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }
}
