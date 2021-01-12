package io.lcalmsky.leetcode.most_frequent_subtree_sum;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

/**
 * <pre>
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * </pre>
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        dfs(root, sumMap);
        List<Integer> result = new ArrayList<>();
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : Collections.unmodifiableSet(sumMap.entrySet())) {
            if (entry.getValue() > max) {
                result = new ArrayList<>();
                result.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue() == max) {
                result.add(entry.getKey());
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode node, Map<Integer, Integer> sumMap) {
        if (node == null) return 0;
        int sum = node.val;
        sum += dfs(node.left, sumMap);
        sum += dfs(node.right, sumMap);
        sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
