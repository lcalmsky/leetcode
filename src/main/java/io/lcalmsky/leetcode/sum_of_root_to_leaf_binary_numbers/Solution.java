package io.lcalmsky.leetcode.sum_of_root_to_leaf_binary_numbers;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int sumRootToLeaf(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return sum(root, 0);
  }

  private int sum(TreeNode node, int parentValue) {
    if (node == null) {
      return 0;
    }
    int current = parentValue * 2 + node.val;
    if (node.left == null && node.right == null) {
      return current;
    }
    return sum(node.left, current) + sum(node.right, current);
  }
}
