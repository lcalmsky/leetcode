package io.lcalmsky.leetcode.the_number_of_week_characters_in_the_game;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{5, 5}, {6, 3}, {3, 6}}, 0),
        () -> test(new int[][]{{2, 2}, {3, 3}}, 1),
        () -> test(new int[][]{{1, 5}, {10, 4}, {4, 3}}, 1)
    );
  }

  private void test(int[][] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numberOfWeakCharacters(given);
    // then
    assertEquals(expected, actual);
  }

}