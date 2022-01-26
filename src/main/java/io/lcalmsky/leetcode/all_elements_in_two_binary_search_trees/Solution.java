package io.lcalmsky.leetcode.all_elements_in_two_binary_search_trees;

import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    List<Integer> result = new ArrayList<>();
    travel(result, root1);
    travel(result, root2);
    Collections.sort(result);
    return result;
  }

  private void travel(List<Integer> result, TreeNode node) {
    if (node == null) {
      return;
    }
    result.add(node.val);
    travel(result, node.left);
    travel(result, node.right);
  }
}
