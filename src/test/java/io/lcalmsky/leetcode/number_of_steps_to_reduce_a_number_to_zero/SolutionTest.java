package io.lcalmsky.leetcode.number_of_steps_to_reduce_a_number_to_zero;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(14, 6),
        () -> test(8, 4),
        () -> test(123, 12)
    );
  }

  private void test(int given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numberOfSteps(given);
    // then
    assertEquals(expected, actual);
  }
}