package io.lcalmsky.leetcode.deepest_leaves_sum;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int deepestLeavesSum(TreeNode root) {
    int depth = countDepth(root);
    return sum(root, 1, depth);
  }

  private int countDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(countDepth(root.left), countDepth(root.right));
  }

  private int sum(TreeNode root, int currentDepth, int depth) {
    if (root == null) {
      return 0;
    }
    if (currentDepth == depth) {
      return root.val;
    }
    return sum(root.left, currentDepth + 1, depth) + sum(root.right, currentDepth + 1, depth);
  }
}
