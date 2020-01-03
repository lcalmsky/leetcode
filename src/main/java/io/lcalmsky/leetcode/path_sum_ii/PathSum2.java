package io.lcalmsky.leetcode.path_sum_ii;

import io.lcalmsky.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        dfs(root, sum - root.val, paths, path);
        return paths;
    }

    public void dfs(TreeNode node, int sum, List<List<Integer>> paths, List<Integer> path) {
        if (node.left == null && node.right == null && sum == 0) {
            paths.add(new ArrayList<>(path));
            return;
        }

        if (node.left != null) {
            int val = node.left.val;
            path.add(val);
            dfs(node.left, sum - val, paths, path);
            path.remove(path.size() - 1);
        }

        if (node.right != null) {
            int val = node.right.val;
            path.add(val);
            dfs(node.right, sum - val, paths, path);
            path.remove(path.size() - 1);
        }
    }
}