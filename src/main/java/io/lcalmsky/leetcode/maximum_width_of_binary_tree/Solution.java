package io.lcalmsky.leetcode.maximum_width_of_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int widthOfBinaryTree(TreeNode root) {
    return dfs(root, 1, 0, new ArrayList<>());
  }

  private int dfs(TreeNode node, Integer index, Integer depth, List<Integer> leftMost) {
    if (node == null) {
      return 0;
    }
    if (depth >= leftMost.size()) {
      leftMost.add(index);
    }
    int current = index - leftMost.get(depth) + 1;
    int left = dfs(node.left, index * 2, depth + 1, leftMost);
    int right = dfs(node.right, index * 2 + 1, depth + 1, leftMost);
    return Math.max(current, Math.max(left, right));
  }
}
