package io.lcalmsky.leetcode.search_insert_position;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 3, 5, 6}, 5, 2),
        () -> test(new int[]{1, 3, 5, 6}, 2, 1),
        () -> test(new int[]{1, 3, 5, 6}, 7, 4),
        () -> test(new int[]{1, 3, 5, 6}, 0, 0),
        () -> test(new int[]{1}, 0, 0)
    );
  }

  private void test(int[] given, int target, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.searchInsert(given, target);
    // then
    assertEquals(expected, actual);
  }
}