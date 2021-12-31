package io.lcalmsky.leetcode.maximum_difference_between_node_and_ancestor;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13), 7),
        () -> test(TreeNode.of(1, null, 2, null, 0, 3), 3)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxAncestorDiff(given);
    // then
    assertEquals(expected, actual);
  }
}