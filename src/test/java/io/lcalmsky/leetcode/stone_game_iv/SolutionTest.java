package io.lcalmsky.leetcode.stone_game_iv;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(1, true),
        () -> test(2, false),
        () -> test(4, true),
        () -> test(8, true)
    );
  }

  private void test(int given, boolean expected) {
    // when
    Solution solution = new Solution();
    boolean actual = solution.winnerSquareGame(given);
    // then
    assertEquals(expected, actual);
  }
}