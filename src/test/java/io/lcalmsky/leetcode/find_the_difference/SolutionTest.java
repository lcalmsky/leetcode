package io.lcalmsky.leetcode.find_the_difference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test("abcd", "abcde", 'e'),
        () -> test("", "y", 'y')
    );
  }

  private void test(String s, String t, char expected) {
    // when
    Solution solution = new Solution();
    char actual = solution.findTheDifference(s, t);
    // then
    assertSame(expected, actual);
  }
}