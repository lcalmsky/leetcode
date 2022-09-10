package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_iv;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, new int[]{2, 4, 1}, 2),
        () -> test(2, new int[]{3, 2, 6, 5, 0, 3}, 7)
    );
  }

  private void test(int k, int[] prices, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxProfit(k, prices);
    // then
    assertEquals(expected, actual);
  }
}