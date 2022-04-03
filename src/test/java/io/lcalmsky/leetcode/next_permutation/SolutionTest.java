package io.lcalmsky.leetcode.next_permutation;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, new int[]{1, 3, 2}),
        () -> test(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
        () -> test(new int[]{1, 1, 5}, new int[]{1, 5, 1})
    );
  }

  private void test(int[] given, int[] expected) {
    // when
    Solution solution = new Solution();
    solution.nextPermutation(given);
    // then
    assertArrayEquals(expected, given);
  }
}