package io.lcalmsky.leetcode.maximum_width_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 * Given a binary tree, write a function to get the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.
 *
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 *
 * It is guaranteed that the answer will in the range of 32-bit signed integer.
 *
 * Example 1:
 *
 * Input:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 *
 * Example 2:
 *
 * Input:
 *
 *           1
 *          /
 *         3
 *        / \
 *       5   3
 *
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 *
 * Example 3:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /
 *       5
 *
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 *
 * Example 4:
 *
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        /     \
 *       5       9
 *      /         \
 *     6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 *
 *
 * Constraints:
 *
 * The given binary tree will have between 1 and 3000 nodes.
 * </pre>
 */
public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> queue = new LinkedList<>();
        List<Integer> idx = new ArrayList<>();
        queue.addLast(root);
        idx.add(0);
        int res = 1;
        while (!queue.isEmpty()) {
            res = Math.max(res, idx.get(idx.size() - 1) - idx.get(0) + 1);
            List<Integer> levelIdx = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.removeFirst();
                if (node.left != null) {
                    queue.addLast(node.left);
                    levelIdx.add(idx.get(i) * 2);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                    levelIdx.add(idx.get(i) * 2 + 1);
                }
            }
            idx = levelIdx;
        }
        return res;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> leftMost = new ArrayList<>();
        return dfs(root, 1, 0, leftMost);
    }

    private int dfs(TreeNode node, Integer idx, Integer depth, List<Integer> leftMost) {
        if (node == null) return 0;
        if (depth >= leftMost.size()) leftMost.add(idx);
        int cur = idx - leftMost.get(depth) + 1;
        int left = dfs(node.left, idx * 2, depth + 1, leftMost);
        int right = dfs(node.right, idx * 2 + 1, depth + 1, leftMost);
        return Math.max(cur, Math.max(left, right));
    }
}
