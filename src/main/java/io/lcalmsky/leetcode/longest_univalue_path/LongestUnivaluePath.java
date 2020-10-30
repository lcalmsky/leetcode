package io.lcalmsky.leetcode.longest_univalue_path;

import io.lcalmsky.leetcode.TreeNode;

/**
 * <pre>
 * Given the root of a binary tree, return the length of the longest path, where each node in the path has the same value. This path may or may not pass through the root.
 *
 * The length of the path between two nodes is represented by the number of edges between them.
 *
 * Example 1:
 *
 * Input: root = [5,4,5,1,1,5]
 * Output: 2
 * Example 2:
 *
 * Input: root = [1,4,5,4,4,5]
 * Output: 2
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 * The depth of the tree will not exceed 1000.
 * </pre>
 */
public class LongestUnivaluePath {
    private int max;

    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        search(root);
        return max;
    }

    private int search(TreeNode root) {
        if (root == null) return 0;
        int left = search(root.left);
        int right = search(root.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (root.left != null && root.val == root.left.val) arrowLeft = left + 1;
        if (root.right != null && root.val == root.right.val) arrowRight = right + 1;
        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}