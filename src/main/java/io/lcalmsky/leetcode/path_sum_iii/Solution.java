package io.lcalmsky.leetcode.path_sum_iii;

import io.lcalmsky.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

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
public class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, 0, targetSum, map);
    }

    public int dfs(TreeNode node, int accumulateSum, int targetSum, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        accumulateSum += node.val;
        int count = map.getOrDefault(accumulateSum - targetSum, 0);
        map.put(accumulateSum, map.getOrDefault(accumulateSum, 0) + 1);
        count += dfs(node.left, accumulateSum, targetSum, map) + dfs(node.right, accumulateSum, targetSum, map);
        map.put(accumulateSum, map.get(accumulateSum) - 1);
        return count;
    }
}