package io.lcalmsky.leetcode.n_ary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

  public List<List<Integer>> levelOrder(Node root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      List<Integer> temp = new ArrayList<>();
      while (n-- > 0) {
        Node node = queue.remove();
        temp.add(node.val);
        queue.addAll(node.children);
      }
      result.add(temp);
    }
    return result;
  }
}
