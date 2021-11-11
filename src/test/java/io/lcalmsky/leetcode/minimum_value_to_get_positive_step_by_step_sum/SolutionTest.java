package io.lcalmsky.leetcode.minimum_value_to_get_positive_step_by_step_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{-3, 2, -3, 4, 2}, 5),
        () -> test(new int[]{1, 2}, 1),
        () -> test(new int[]{1, -2, -3}, 5)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minStartValue(given);
    // then
    assertEquals(expected, actual);
  }
}