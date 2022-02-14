package io.lcalmsky.leetcode.maximum_depth_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftDepth = maxDepth(root.left);
    int rightDepth = maxDepth(root.right);
    return Math.max(leftDepth, rightDepth) + 1;
  }
}
