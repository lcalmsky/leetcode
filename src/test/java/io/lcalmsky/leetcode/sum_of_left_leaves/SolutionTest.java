package io.lcalmsky.leetcode.sum_of_left_leaves;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.lcalmsky.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTreeNodes_whenSumLeftLeaves_thenCorrect() {
    assertAll(
        () -> test(TreeNode.of(3, 9, 20, null, null, 15, 7), 24)
    );
  }

  private void test(TreeNode given, int expected) {
    // when
    Solution sumOfLeftLeaves = new Solution();
    int actual = sumOfLeftLeaves.sumOfLeftLeaves(given);

    // then
    assertEquals(expected, actual);
  }
}