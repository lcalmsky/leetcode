package io.lcalmsky.leetcode.trim_a_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public TreeNode trimBST(TreeNode root, int low, int high) {
    if (root == null) {
      return null;
    }
    if (root.val > high) {
      return trimBST(root.left, low, high);
    }
    if (root.val < low) {
      return trimBST(root.right, low, high);
    }
    root.left = trimBST(root.left, low, root.val);
    root.right = trimBST(root.right, root.val, high);
    return root;
  }
}
