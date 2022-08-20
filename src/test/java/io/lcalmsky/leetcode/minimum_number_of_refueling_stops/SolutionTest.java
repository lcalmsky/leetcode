package io.lcalmsky.leetcode.minimum_number_of_refueling_stops;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, 1, new int[][]{}, 0),
        () -> test(100, 1, new int[][]{{10, 100}}, -1),
        () -> test(1, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}, 2)
    );
  }

  private void test(int target, int startFuel, int[][] stations, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minRefuelStops(target, startFuel, stations);
    // then
    assertEquals(expected, actual);
  }
}