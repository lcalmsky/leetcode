package io.lcalmsky.leetcode.add_digits;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenDigit_whenAddUntilOneDigit_thenCorrect() {
    assertAll(
        () -> test(38, 2),
        () -> test(0, 0)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution addDigits = new Solution();
    int actual = addDigits.addDigits(given);
    // then
    assertEquals(expected, actual);
  }
}