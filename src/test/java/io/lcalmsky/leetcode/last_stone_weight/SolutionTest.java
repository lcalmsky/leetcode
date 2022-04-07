package io.lcalmsky.leetcode.last_stone_weight;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 7, 4, 1, 8, 1}, 1),
        () -> test(new int[]{1}, 1),
        () -> test(new int[]{1, 3}, 2)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.lastStoneWeight(given);
    // then
    assertEquals(expected, actual);
  }
}