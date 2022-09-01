package io.lcalmsky.leetcode.count_good_nodes_in_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  private int numGoodNodes = 0;

  public int goodNodes(TreeNode root) {
    dfs(root, Integer.MIN_VALUE);
    return numGoodNodes;
  }

  private void dfs(TreeNode node, int maxSoFar) {
    if (maxSoFar <= node.val) {
      numGoodNodes++;
    }
    if (node.right != null) {
      dfs(node.right, Math.max(node.val, maxSoFar));
    }
    if (node.left != null) {
      dfs(node.left, Math.max(node.val, maxSoFar));
    }
  }
}
