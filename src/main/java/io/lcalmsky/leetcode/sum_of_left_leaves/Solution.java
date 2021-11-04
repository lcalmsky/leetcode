package io.lcalmsky.leetcode.sum_of_left_leaves;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int sum = 0;
    if (root.left != null) {
      if (isLeaf(root.left)) {
        sum += root.left.val;
      } else {
        sum += sumOfLeftLeaves(root.left);
      }
    }
    sum += sumOfLeftLeaves(root.right);
    return sum;
  }

  private boolean isLeaf(TreeNode node) {
    return node.left == null && node.right == null;
  }
}