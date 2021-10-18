package io.lcalmsky.leetcode.cousins_in_binary_tree;

import io.lcalmsky.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        dfs(depthMap, parentMap, root, null, 1);
        return depthMap.get(x).equals(depthMap.get(y)) &&
                !parentMap.get(x).equals(parentMap.get(y));
    }

    private void dfs(Map<Integer, Integer> depthMap, Map<Integer, Integer> parentMap,
                     TreeNode currentNode, TreeNode parentNode, int depth) {
        if (currentNode == null) {
            return;
        }
        depthMap.put(currentNode.val, depth);
        parentMap.put(currentNode.val, parentNode == null ? null : parentNode.val);
        dfs(depthMap, parentMap, currentNode.left, currentNode, depth + 1);
        dfs(depthMap, parentMap, currentNode.right, currentNode, depth + 1);
    }
}