package io.lcalmsky.leetcode.convert_sorted_array_to_binary_search_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return bst(nums, 0, nums.length - 1);
    }

    private TreeNode bst(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(nums, start, mid - 1);
        root.right = bst(nums, mid + 1, end);
        return root;
    }
}
