package io.lcalmsky.leetcode.reordered_power_of_2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, true),
        () -> test(10, false),
        () -> test(4201, true),
        () -> test(46, true)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.reorderedPowerOf2(given);
    // then
    assertEquals(expected, actual);
  }
}