package io.lcalmsky.leetcode.richest_customer_wealth;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 2, 3}, {3, 2, 1}}, 6),
        () -> test(new int[][]{{1, 5}, {7, 3}, {3, 5}}, 10),
        () -> test(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}, 17)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maximumWealth(given);
    // then
    assertEquals(expected, actual);
  }
}