package io.lcalmsky.leetcode.smallest_subtree_with_all_the_deepest_nodes;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).treeNode;
    }

    public NodeWithDistance dfs(TreeNode node) {
        if (node == null) return new NodeWithDistance(null, 0);
        NodeWithDistance left = dfs(node.left), right = dfs(node.right);
        return left.distance > right.distance ? new NodeWithDistance(left.treeNode, left.distance + 1) :
                left.distance < right.distance ? new NodeWithDistance(right.treeNode, right.distance + 1) :
                        new NodeWithDistance(node, left.distance + 1);
    }

    public static class NodeWithDistance {
        private final TreeNode treeNode;
        private final int distance;

        public NodeWithDistance(TreeNode treeNode, int distance) {
            this.treeNode = treeNode;
            this.distance = distance;
        }
    }
}
