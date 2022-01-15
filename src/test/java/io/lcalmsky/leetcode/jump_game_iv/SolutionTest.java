package io.lcalmsky.leetcode.jump_game_iv;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}, 3),
        () -> test(new int[]{7}, 0),
        () -> test(new int[]{7, 6, 9, 6, 9, 6, 9, 7}, 1)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.minJumps(given);
    // then
    assertEquals(expected, actual);
  }
}