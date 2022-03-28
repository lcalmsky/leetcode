package io.lcalmsky.leetcode.search_in_rotated_sorted_array_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenRotatedSortedArray_whenSearch_thenCorrect() {
    assertAll(
        () -> test(new int[]{2, 5, 6, 0, 0, 1, 2}, 0, true),
        () -> test(new int[]{2, 5, 6, 0, 0, 1, 2}, 3, false)
    );
  }

  private void test(int[] givenArray, int givenTarget, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.search(givenArray, givenTarget);
    // then
    assertEquals(expected, actual);
  }
}