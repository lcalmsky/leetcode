package io.lcalmsky.leetcode.min_cost_climbing_stairs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenCosts_whenClimbStairs_thenGetMinimumCost() {
    assertAll(
        () -> test(new int[]{10, 15, 20}, 15),
        () -> test(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}, 6)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minCostClimbingStairs(given);

    // then
    assertEquals(expected, actual);
  }
}
