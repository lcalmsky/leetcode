package io.lcalmsky.leetcode.lowest_common_ancester_of_a_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root == p || root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left == null && right == null) {
      return null;
    }
    if (left != null && right != null) {
      return root;
    }
    return left == null ? right : left;
  }

}
