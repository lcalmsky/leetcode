package io.lcalmsky.leetcode.reduce_array_size_to_the_half;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}, 2),
        () -> test(new int[]{7, 7, 7, 7, 7, 7}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minSetSize(given);
    // then
    assertEquals(expected, actual);
  }
}