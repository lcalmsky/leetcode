package io.lcalmsky.leetcode.container_with_most_water;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
        () -> test(new int[]{1, 1}, 1)
    );

  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxArea(given);
    // then
    assertEquals(expected, actual);
  }
}