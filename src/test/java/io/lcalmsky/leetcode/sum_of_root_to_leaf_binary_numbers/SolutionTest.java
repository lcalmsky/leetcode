package io.lcalmsky.leetcode.sum_of_root_to_leaf_binary_numbers;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(1, 0, 1, 0, 1, 0, 1), 22),
        () -> test(TreeNode.of(0), 0)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.sumRootToLeaf(given);
    // then
    assertEquals(expected, actual);
  }
}