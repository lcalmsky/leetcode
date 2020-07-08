package io.lcalmsky.leetcode.find_bottom_left_tree_value;

import io.lcalmsky.leetcode.TreeNode;

/**
 * <pre>
 * Given a binary tree, find the leftmost value in the last row of the tree.
 *
 * Example 1:
 * Input:
 *
 *     2
 *    / \
 *   1   3
 *
 * Output:
 * 1
 * Example 2:
 * Input:
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   5   6
 *        /
 *       7
 *
 * Output:
 * 7
 * Note: You may assume the tree (i.e., the given root node) is not NULL.
 * </pre>
 */
public class FindBottomLeftTreeValue {
    private int value;
    private int maxRow = -1;

    public int findBottomLeftValue(TreeNode root) {
        traverse(root, 0);
        return value;
    }

    private void traverse(TreeNode node, int level) {
        if (node == null) return;
        if (level > maxRow) {
            maxRow = level;
            value = node.val;
        }
        if (node.left != null) traverse(node.left, level + 1);
        if (node.right != null) traverse(node.right, level + 1);
    }
}
