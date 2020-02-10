package io.lcalmsky.leetcode.kth_smallest_element_in_a_bst;

import io.lcalmsky.leetcode.TreeNode;

import java.util.Stack;

public class KthSmallestElementInABst {
    public int kthSmallest(TreeNode treeNode, int k) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = treeNode;
        int result = 0;

        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode t = stack.pop();
                k--;
                if (k == 0)
                    result = t.val;
                p = t.right;
            }
        }

        return result;
    }
}
