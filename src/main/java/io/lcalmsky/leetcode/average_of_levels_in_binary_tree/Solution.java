package io.lcalmsky.leetcode.average_of_levels_in_binary_tree;

import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<Double> averageOfLevels(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      double sum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        sum += node.val;
        if (node.left != null) {
          queue.offer(node.left);
        }
        if (node.right != null) {
          queue.offer(node.right);
        }
      }
      result.add(sum / size);
    }
    return result;
  }
}
