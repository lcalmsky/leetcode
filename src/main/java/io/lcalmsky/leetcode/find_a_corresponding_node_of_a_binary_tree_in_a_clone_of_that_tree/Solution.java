package io.lcalmsky.leetcode.find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  private TreeNode result;

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
      final TreeNode target) {
    inorder(original, cloned, target);
    return result;
  }

  private void inorder(TreeNode original, TreeNode cloned, TreeNode target) {
    if (original == null) {
      return;
    }
    inorder(original.left, cloned.left, target);
    if (original == target) {
      result = cloned;
      return;
    }
    inorder(original.right, cloned.right, target);
  }
}
