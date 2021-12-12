package io.lcalmsky.leetcode.partition_equal_subset_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenSumSubsets_thenEqualsPartition() {
    assertAll(
        () -> test(new int[]{1, 5, 11, 5}, true),
        () -> test(new int[]{1, 2, 3, 4, 5}, false)
    );
  }

  private void test(int[] given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.canPartition(given);

    // then
    assertEquals(expected, actual);
  }
}