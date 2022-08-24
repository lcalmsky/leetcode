package io.lcalmsky.leetcode.power_of_tree;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(27, true),
        () -> test(0, false),
        () -> test(9, true)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.isPowerOfThree(given);
    // then
    assertEquals(expected, actual);
  }
}