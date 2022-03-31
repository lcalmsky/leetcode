package io.lcalmsky.leetcode.split_array_largest_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{7, 2, 5, 10, 8}, 2, 18),
        () -> test(new int[]{1, 2, 3, 4, 5}, 2, 9),
        () -> test(new int[]{1, 4, 4}, 3, 4)
    );
  }

  private void test(int[] nums, int m, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.splitArray(nums, m);
    // then
    assertEquals(expected, actual);
  }
}