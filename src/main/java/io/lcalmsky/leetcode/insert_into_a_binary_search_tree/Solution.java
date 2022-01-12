package io.lcalmsky.leetcode.insert_into_a_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public TreeNode insertIntoBST(TreeNode root, int val) {
    if (root == null) {
      return new TreeNode(val);
    }
    traverse(root, val);
    return root;
  }

  private void traverse(TreeNode root, int val) {
    if (root == null) {
      return;
    }
    if (val > root.val) {
      if (root.right == null) {
        root.right = new TreeNode(val);
        return;
      }
      traverse(root.right, val);
    } else {
      if (root.left == null) {
        root.left = new TreeNode(val);
        return;
      }
      traverse(root.left, val);
    }
  }
}
