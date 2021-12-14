package io.lcalmsky.leetcode.range_sum_of_bst;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(TreeNode.of(10, 5, 15, 3, 7, null, 18), 7, 15, 32),
        () -> test(TreeNode.of(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10, 23)
    );
  }

  private void test(TreeNode root, int low, int high, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.rangeSumBST(root, low, high);
    // then
    assertEquals(expected, actual);
  }
}