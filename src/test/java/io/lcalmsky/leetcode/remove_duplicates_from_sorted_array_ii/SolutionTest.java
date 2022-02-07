package io.lcalmsky.leetcode.remove_duplicates_from_sorted_array_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 1, 2, 2, 3}, 5),
        () -> test(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, 7)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.removeDuplicates(given);
    // then
    assertEquals(expected, actual);
  }
}