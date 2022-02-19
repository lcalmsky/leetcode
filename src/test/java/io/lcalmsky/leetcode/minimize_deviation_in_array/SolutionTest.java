package io.lcalmsky.leetcode.minimize_deviation_in_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4}, 1),
        () -> test(new int[]{4, 1, 5, 20, 3}, 3),
        () -> test(new int[]{2, 10, 8}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minimumDeviation(given);
    // then
    assertEquals(expected, actual);
  }
}