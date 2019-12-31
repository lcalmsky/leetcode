package io.lcalmsky.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int iStart = 0, iEnd = inorder.length - 1, pStart = 0, pEnd = postorder.length - 1;
        return buildTree(inorder, iStart, iEnd, postorder, pStart, pEnd);
    }

    public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        int k = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                k = i;
                break;
            }
        }

        root.left = buildTree(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
        root.right = buildTree(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1);
        return root;
    }
}
