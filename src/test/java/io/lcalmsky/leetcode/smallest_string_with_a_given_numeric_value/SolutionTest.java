package io.lcalmsky.leetcode.smallest_string_with_a_given_numeric_value;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(3, 27, "aay"),
        () -> test(5, 73, "aaszz")
    );
  }

  private void test(int n, int k, String expected) {
    // when
    Solution solution = new Solution();
    String actual = solution.getSmallestString(n, k);
    // then
    assertEquals(expected, actual);
  }
}