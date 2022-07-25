package io.lcalmsky.leetcode.find_first_and_last_position_of_element_in_sorted_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
        () -> test(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
        () -> test(new int[]{}, 0, new int[]{-1, -1})
    );
  }

  private void test(int[] nums, int target, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.searchRange(nums, target);
    // then
    assertArrayEquals(expected, actual);
  }
}