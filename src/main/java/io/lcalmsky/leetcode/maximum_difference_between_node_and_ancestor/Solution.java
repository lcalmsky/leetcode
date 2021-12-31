package io.lcalmsky.leetcode.maximum_difference_between_node_and_ancestor;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int maxAncestorDiff(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return maxDiff(root, root.val, root.val);
  }

  private int maxDiff(TreeNode node, int min, int max) {
    if (node == null) {
      return Math.abs(max - min);
    }
    if (node.val < min) {
      min = node.val;
    }
    if (node.val > max) {
      max = node.val;
    }
    return Math.max(maxDiff(node.left, min, max), maxDiff(node.right, min, max));
  }
}
