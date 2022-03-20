package io.lcalmsky.leetcode.minimum_domino_rotations_for_equal_row;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 1, 2, 4, 2, 2}, new int[]{5, 2, 6, 2, 3, 2}, 2),
        () -> test(new int[]{3, 5, 1, 2, 3}, new int[]{3, 6, 3, 3, 4}, -1)
    );
  }

  private void test(int[] tops, int[] bottoms, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minDominoRotations(tops, bottoms);
    // then
    assertEquals(expected, actual);
  }
}