package io.lcalmsky.leetcode.count_good_nodes_in_binary_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(3, 1, 4, 3, null, 1, 5), 4),
        () -> test(TreeNode.of(3, 3, null, 4, 2), 3),
        () -> test(TreeNode.of(1), 1)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.goodNodes(given);
    // then
    assertEquals(expected, actual);
  }

}