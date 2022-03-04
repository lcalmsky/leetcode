package io.lcalmsky.leetcode.champagne_tower;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, 1, 1, 0d),
        () -> test(2, 1, 1, 0.5d),
        () -> test(100000009, 33, 17, 1d)
    );
  }

  private void test(int poured, int queryRow, int queryGlass, double expected) {
    // when
    Solution solution = new Solution();
    double actual = solution.champagneTower(poured, queryRow, queryGlass);
    // then
    assertEquals(expected, actual);
  }
}