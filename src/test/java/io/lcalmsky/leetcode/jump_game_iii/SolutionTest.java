package io.lcalmsky.leetcode.jump_game_iii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{4, 2, 3, 0, 3, 1, 2}, 5, true),
        () -> test(new int[]{4, 2, 3, 0, 3, 1, 2}, 0, true),
        () -> test(new int[]{3, 0, 2, 1, 2}, 2, false)
    );
  }

  private void test(int[] arr, int start, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.canReach(arr, start);
    // then
    assertEquals(expected, actual);
  }
}