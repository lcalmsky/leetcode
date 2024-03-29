package io.lcalmsky.leetcode.house_robber;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenRobbing_thenDetermineMaximumAmount() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 1}, 4),
        () -> test(new int[]{2, 7, 9, 3, 1}, 12),
        () -> test(new int[]{2, 1, 1, 2}, 4)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution houseRobber = new Solution();
    int actual = houseRobber.rob(given);

    // then
    assertEquals(expected, actual);
  }
}