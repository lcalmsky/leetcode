package io.lcalmsky.leetcode.roman_to_integer;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("III", 3),
        () -> test("LVIII", 58),
        () -> test("MCMXCIV", 1994)
    );
  }

  private void test(String given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.romanToInt(given);
    // then
    assertEquals(expected, actual);
  }
}