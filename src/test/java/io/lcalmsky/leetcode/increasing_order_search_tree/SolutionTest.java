package io.lcalmsky.leetcode.increasing_order_search_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9),
            TreeNode.of(1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9)),
        () -> test(TreeNode.of(5, 1, 7), TreeNode.of(1, null, 5, null, 7))
    );
  }

  private void test(TreeNode given, TreeNode expected) {
    // when
    Solution solution = new Solution();
    TreeNode actual = solution.increasingBST(given);
    // then
    assertEquals(expected, actual);
  }
}