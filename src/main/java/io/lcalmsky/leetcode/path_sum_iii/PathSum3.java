package io.lcalmsky.leetcode.path_sum_iii;

import io.lcalmsky.leetcode.TreeNode;

/**
 * <pre>
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * </pre>
 */
public class PathSum3 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSequenceSum(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSequenceSum(TreeNode node, int sum) {
        if (node == null) return 0;
        int count = (sum == node.val) ? 1 : 0;
        count += pathSequenceSum(node.left, sum - node.val) + pathSequenceSum(node.right, sum - node.val);
        return count;
    }
}
