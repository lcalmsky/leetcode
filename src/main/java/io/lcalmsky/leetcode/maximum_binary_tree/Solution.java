package io.lcalmsky.leetcode.maximum_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, int left, int right) {
        if (left == right) return null;
        int maxIndex = left;
        for (int i = left; i < right; i++) maxIndex = nums[i] > nums[maxIndex] ? i : maxIndex;
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = construct(nums, left, maxIndex);
        root.right = construct(nums, maxIndex + 1, right);
        return root;
    }
}
