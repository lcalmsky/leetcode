package io.lcalmsky.leetcode.valid_mountain_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 1}, false),
        () -> test(new int[]{3, 5, 5}, false),
        () -> test(new int[]{0, 3, 2, 1}, true)
    );
  }

  private void test(int[] given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.validMountainArray(given);
    // then
    assertEquals(expected, actual);
  }
}