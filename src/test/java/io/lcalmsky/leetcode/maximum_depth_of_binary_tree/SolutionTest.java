package io.lcalmsky.leetcode.maximum_depth_of_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), 3),
        () -> test(TreeNode.of(1, null, 2), 2)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxDepth(given);
    // then
    assertEquals(expected, actual);
  }
}