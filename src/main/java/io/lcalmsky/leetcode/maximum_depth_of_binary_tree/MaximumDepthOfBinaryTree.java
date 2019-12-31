package io.lcalmsky.leetcode.maximum_depth_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        int depth = 0, size;
        TreeNode node;
        while (!treeNodeQueue.isEmpty()) {
            depth++;
            size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                node = treeNodeQueue.poll();
                if (node.left != null) treeNodeQueue.offer(node.left);
                if (node.right != null) treeNodeQueue.offer(node.right);
            }
        }

        return depth;
    }
}
