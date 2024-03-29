package io.lcalmsky.leetcode.search_in_a_binary_search_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTreeNode_whenFindTargetNumber_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(4, 2, 7, 1, 3), 2, TreeNode.of(2, 1, 3)),
        () -> test(TreeNode.of(4, 2, 7, 1, 3), 5, null)
    );
  }

  private void test(TreeNode given, int k, TreeNode expected) {
    Solution solution = new Solution();
    TreeNode actual = solution.searchBST(given, k);
    assertEquals(expected, actual);
  }
}
