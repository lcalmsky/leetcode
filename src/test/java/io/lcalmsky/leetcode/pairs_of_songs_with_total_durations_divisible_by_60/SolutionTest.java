package io.lcalmsky.leetcode.pairs_of_songs_with_total_durations_divisible_by_60;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void numPairsDivisibleBy60() {
    assertAll(
        () -> test(new int[]{30, 20, 150, 100, 40}, 3),
        () -> test(new int[]{60, 60, 60}, 3)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.numPairsDivisibleBy60(given);
    // then
    assertEquals(expected, actual);
  }
}