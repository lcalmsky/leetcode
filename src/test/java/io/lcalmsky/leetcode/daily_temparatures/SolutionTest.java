package io.lcalmsky.leetcode.daily_temparatures;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenTemperatures_whenCountDaysUntilWarmerTemperature_thenCorrect() {
    assertAll(
        () -> test(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
        () -> test(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
        () -> test(new int[]{30, 60, 90}, new int[]{1, 1, 0})
    );
  }

  private void test(int[] given, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.dailyTemperatures(given);

    // then
    assertArrayEquals(expected, actual);
  }
}
