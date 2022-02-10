package io.lcalmsky.leetcode.subarray_sum_equals_k;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 1}, 2, 2),
        () -> test(new int[]{1, 2, 3}, 3, 2)
    );
  }

  private void test(int[] given, int k, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.subarraySum(given, k);
    // then
    assertEquals(expected, actual);
  }
}