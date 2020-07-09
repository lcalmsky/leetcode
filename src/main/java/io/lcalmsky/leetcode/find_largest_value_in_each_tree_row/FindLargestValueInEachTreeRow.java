package io.lcalmsky.leetcode.find_largest_value_in_each_tree_row;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * You need to find the largest value in each row of a binary tree.
 *
 * Example:
 * Input:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * Output: [1, 3, 9]
 * </pre>
 */
public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<Integer> list = new ArrayList<>();
        traverse(root, list, 0);
        return list;
    }

    private void traverse(TreeNode node, List<Integer> list, int level) {
        if (node == null) return;
        if (level >= list.size()) list.add(node.val);
        list.set(level, Math.max(list.get(level), node.val));
        traverse(node.left, list, level + 1);
        traverse(node.right, list, level + 1);
    }
}
