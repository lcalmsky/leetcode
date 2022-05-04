package io.lcalmsky.leetcode.max_number_of_k_sum_pairs;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4}, 5, 2),
        () -> test(new int[]{3, 1, 3, 4, 3}, 6, 1)
    );
  }

  private void test(int[] given, int k, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.maxOperations(given, k);
    // then
    assertEquals(expected, actual);
  }
}