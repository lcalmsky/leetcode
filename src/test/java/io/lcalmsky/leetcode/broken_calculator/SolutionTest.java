package io.lcalmsky.leetcode.broken_calculator;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, 3, 2),
        () -> test(5, 8, 2),
        () -> test(3, 10, 3)
    );
  }

  private void test(int startValue, int target, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.brokenCalc(startValue, target);
    // then
    assertEquals(expected, actual);
  }
}