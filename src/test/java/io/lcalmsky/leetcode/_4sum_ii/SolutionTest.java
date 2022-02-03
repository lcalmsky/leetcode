package io.lcalmsky.leetcode._4sum_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2),
        () -> test(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, 1)
    );
  }

  private void test(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.fourSumCount(nums1, nums2, nums3, nums4);
    // then
    assertEquals(expected, actual);
  }
}