package io.lcalmsky.leetcode.increasing_order_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  private TreeNode head;
  private TreeNode current;

  public TreeNode increasingBST(TreeNode root) {
    traverse(root);
    return head;
  }

  private void traverse(TreeNode node) {
    if (node == null) {
      return;
    }
    traverse(node.left);
    TreeNode n = new TreeNode(node.val);
    if (head == null) {
      head = n;
      current = n;
    } else {
      current.right = n;
      current = current.right;
    }
    traverse(node.right);
  }
}
