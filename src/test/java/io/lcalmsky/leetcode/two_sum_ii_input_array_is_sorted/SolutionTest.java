package io.lcalmsky.leetcode.two_sum_ii_input_array_is_sorted;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenArray_whenSumTwoElements_thenGetIndices() {
    assertAll(
        () -> test(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
        () -> test(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
        () -> test(new int[]{-1, 0}, -1, new int[]{1, 2})
    );
  }

  private void test(int[] given, int target, int[] expected) {
    // when
    Solution twoSumInputArrayIsSorted = new Solution();
    int[] actual = twoSumInputArrayIsSorted.twoSum(given, target);

    // then
    assertArrayEquals(expected, actual);
  }
}