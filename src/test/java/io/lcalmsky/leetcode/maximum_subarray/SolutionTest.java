package io.lcalmsky.leetcode.maximum_subarray;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6),
        () -> test(new int[]{1}, 1),
        () -> test(new int[]{5, 4, -1, 7, 8}, 23)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxSubArray(given);
    // then
    assertEquals(expected, actual);
  }
}