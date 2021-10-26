package io.lcalmsky.leetcode.construct_binary_search_tree_from_preorder_traversal;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorder(int[] preorder, int max) {
        if (index == preorder.length || preorder[index] > max) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[index++]);
        node.left = bstFromPreorder(preorder, node.val);
        node.right = bstFromPreorder(preorder, max);
        return node;
    }
}