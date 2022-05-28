package io.lcalmsky.leetcode.missing_number;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 0, 1}, 2),
        () -> test(new int[]{0, 1}, 2),
        () -> test(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.missingNumber(given);
    // then
    assertEquals(expected, actual);
  }
}