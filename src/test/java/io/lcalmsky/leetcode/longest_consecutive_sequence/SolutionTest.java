package io.lcalmsky.leetcode.longest_consecutive_sequence;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenArray_whenGetLongestConsecutiveSequence_thenCorrect() {
    assertAll(
        () -> test(new int[]{100, 4, 200, 1, 3, 2}, 4),
        () -> test(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.longestConsecutive(given);
    // then
    assertEquals(expected, actual);
  }
}