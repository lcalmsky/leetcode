package io.lcalmsky.leetcode.binary_search;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenSortedArray_whenFindNumber_thenReturnsItsIndexCorrectly() {
    assertAll(
        () -> test(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
        () -> test(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
    );
  }

  private void test(int[] given, int target, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.search(given, target);
    // then
    assertEquals(expected, actual);
  }
}
