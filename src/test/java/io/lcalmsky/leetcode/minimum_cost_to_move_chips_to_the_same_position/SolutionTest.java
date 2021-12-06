package io.lcalmsky.leetcode.minimum_cost_to_move_chips_to_the_same_position;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, 1),
        () -> test(new int[]{2, 2, 2, 3, 3}, 2),
        () -> test(new int[]{1, 100000000}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minCostToMoveChips(given);
    // then
    assertEquals(expected, actual);
  }
}