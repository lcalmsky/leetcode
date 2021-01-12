package io.lcalmsky.leetcode.find_duplicate_subtrees;

import io.lcalmsky.leetcode.TreeNode;

import java.util.*;

/**
 * <pre>
 * Given the root of a binary tree, return all duplicate subtrees.
 *
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 *
 * Two trees are duplicate if they have the same structure with the same node values.
 *
 *
 * Example 1:
 *
 * Input: root = [1,2,3,4,null,2,4,null,null,4]
 * Output: [[2,4],[4]]
 *
 * Example 2:
 *
 * Input: root = [2,1,1]
 * Output: [[1]]
 *
 * Example 3:
 *
 * Input: root = [2,2,2,3,null,3,null]
 * Output: [[2,3],[3]]
 * </pre>
 */
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        helper(root, map, res);
        return res;
    }

    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) return "#";
        String str = String.format("%d,%s%s", root.val, helper(root.left, map, res), helper(root.right, map, res));
        map.put(str, map.getOrDefault(str, 0) + 1);
        if (map.get(str) == 2) res.add(root);
        return str;
    }
}
