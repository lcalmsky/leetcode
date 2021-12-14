package io.lcalmsky.leetcode.range_sum_of_bst;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public int rangeSumBST(TreeNode root, int low, int high) {
    if (root == null) {
      return 0;
    }
    if (root.val < low) {
      return rangeSumBST(root.right, low, high);
    }
    if (root.val > high) {
      return rangeSumBST(root.left, low, high);
    }
    return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
  }
}
