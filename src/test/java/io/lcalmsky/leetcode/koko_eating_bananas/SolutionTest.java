package io.lcalmsky.leetcode.koko_eating_bananas;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 6, 7, 11}, 8, 4),
        () -> test(new int[]{30, 11, 23, 4, 20}, 5, 30),
        () -> test(new int[]{30, 11, 23, 4, 20}, 6, 23)
    );
  }

  private void test(int[] piles, int h, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minEatingSpeed(piles, h);
    // then
    assertEquals(expected, actual);
  }
}