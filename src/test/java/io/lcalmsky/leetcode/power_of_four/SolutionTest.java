package io.lcalmsky.leetcode.power_of_four;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(16, true),
        () -> test(5, false),
        () -> test(1, true)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.isPowerOfFour(given);
    // then
    assertEquals(expected, actual);
  }
}