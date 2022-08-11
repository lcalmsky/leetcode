package io.lcalmsky.leetcode.validate_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
  }

  private boolean isValidBST(TreeNode node, double min, double max) {
    if (node == null) {
      return true;
    }
    if (node.val <= min || node.val >= max) {
      return false;
    }
    return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
  }
}
