package io.lcalmsky.leetcode.deepest_leaves_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8), 15),
        () -> test(TreeNode.of(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5), 19)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.deepestLeavesSum(given);
    // then
    assertEquals(expected, actual);
  }
}