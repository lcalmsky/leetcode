package io.lcalmsky.leetcode.car_pooling;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4, false),
        () -> test(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5, true)
    );
  }

  private void test(int[][] trips, int capacity, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.carPooling(trips, capacity);
    // then
    assertEquals(expected, actual);
  }
}