package io.lcalmsky.leetcode.binary_tree_inorder_traversal;

import io.lcalmsky.leetcode.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<Integer> result = new ArrayList<>();
    travel(result, root);
    return result;
  }

  private void travel(List<Integer> result, TreeNode root) {
    if (root == null) {
      return;
    }
    travel(result, root.left);
    result.add(root.val);
    travel(result, root.right);
  }
}
