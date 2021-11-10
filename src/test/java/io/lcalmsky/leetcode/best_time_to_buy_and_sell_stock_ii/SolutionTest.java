package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{7, 1, 5, 3, 6, 4}, 7),
        () -> test(new int[]{1, 2, 3, 4, 5}, 4),
        () -> test(new int[]{7, 6, 4, 3, 1}, 0)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxProfit(given);
    // then
    assertEquals(expected, actual);
  }
}