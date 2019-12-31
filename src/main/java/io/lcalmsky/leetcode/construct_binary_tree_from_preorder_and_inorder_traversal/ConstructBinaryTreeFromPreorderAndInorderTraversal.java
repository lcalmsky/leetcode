package io.lcalmsky.leetcode.construct_binary_tree_from_preorder_and_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int pStart = 0, pEnd = preorder.length - 1, iStart = 0, iEnd = inorder.length - 1;
        return construct(preorder, inorder, pStart, pEnd, iStart, iEnd);
    }

    private TreeNode construct(int[] preorder, int[] inorder, int pStart, int pEnd, int iStart, int iEnd) {
        if (pStart > pEnd || iStart > iEnd) return null;

        int val = preorder[pStart];
        TreeNode p = new TreeNode(val);

        int parentIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                parentIndex = i;
                break;
            }
        }

        p.left = construct(preorder, inorder, pStart + 1, pStart + parentIndex - iStart, iStart, parentIndex - 1);
        p.right = construct(preorder, inorder, pStart + parentIndex - iStart + 1, pEnd, parentIndex + 1, iEnd);

        return p;
    }
}
