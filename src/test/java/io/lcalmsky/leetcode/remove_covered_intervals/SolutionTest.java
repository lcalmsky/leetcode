package io.lcalmsky.leetcode.remove_covered_intervals;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 4}, {3, 6}, {2, 8}}, 2),
        () -> test(new int[][]{{1, 4}, {2, 3}}, 1)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.removeCoveredIntervals(given);
    // then
    assertEquals(expected, actual);
  }
}