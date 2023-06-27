package io.lcalmsky.leetcode.kth_smallest_element_in_a_bst;

import io.lcalmsky.leetcode.TreeNode;

import java.util.Stack;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                k--;
                if (k == 0) {
                    return pop.val;
                }
                node = pop.right;
            }
        }
        return -1;
    }
}
