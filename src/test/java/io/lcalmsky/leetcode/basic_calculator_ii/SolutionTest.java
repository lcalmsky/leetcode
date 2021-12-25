package io.lcalmsky.leetcode.basic_calculator_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
//        () -> test("3+2*2", 7),
//        () -> test(" 3/2 ", 1),
//        () -> test(" 3+5 / 2 ", 5),
//        () -> test(" 1+1+1 ", 3),
        () -> test(" 1-1+1 ", 1)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.calculate(given);
    // then
    assertEquals(expected, actual);
  }
}