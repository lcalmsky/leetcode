package io.lcalmsky.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
  }

  public TreeNode buildTree(int[] inorder, int inorderLeft, int inorderRight,
      int[] postorder, int postorderLeft, int postorderRight) {
    if (inorderLeft > inorderRight || postorderLeft > postorderRight) {
      return null;
    }
    int rootValue = postorder[postorderRight];
    TreeNode root = new TreeNode(rootValue);
    int rootIndexOfInorder = getRootIndexOfInorder(inorder, rootValue);
    root.left = buildTree(inorder, inorderLeft, rootIndexOfInorder - 1,
        postorder, postorderLeft, postorderLeft + rootIndexOfInorder - (inorderLeft + 1));
    root.right = buildTree(inorder, rootIndexOfInorder + 1, inorderRight,
        postorder, postorderLeft + rootIndexOfInorder - inorderLeft, postorderRight - 1);
    return root;
  }

  private int getRootIndexOfInorder(int[] inorder, int rootValue) {
    for (int i = 0; i < inorder.length; i++) {
      if (inorder[i] == rootValue) {
        return i;
      }
    }
    throw new IllegalStateException();
  }
}
