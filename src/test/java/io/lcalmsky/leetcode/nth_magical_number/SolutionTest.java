package io.lcalmsky.leetcode.nth_magical_number;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, 2, 3, 2),
        () -> test(4, 2, 3, 6),
        () -> test(5, 2, 4, 10),
        () -> test(3, 6, 4, 8)
    );
  }

  private void test(int n, int a, int b, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.nthMagicalNumber(n, a, b);
    // then
    assertEquals(expected, actual);
  }
}