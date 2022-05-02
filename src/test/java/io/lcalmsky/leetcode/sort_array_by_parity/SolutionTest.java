package io.lcalmsky.leetcode.sort_array_by_parity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{3, 1, 2, 4}, new int[]{4, 2, 1, 3}),
        () -> test(new int[]{0}, new int[]{0})
    );
  }

  private void test(int[] given, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.sortArrayByParity(given);
    // then
    assertArrayEquals(expected, actual);
  }
}