package io.lcalmsky.leetcode.number_of_1_bits;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(521, 3),
        () -> test(2097152, 1),
        () -> test(-3, 31)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.hammingWeight(given);
    // then
    assertEquals(expected, actual);
  }
}