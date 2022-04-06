package io.lcalmsky.leetcode._3sum_with_multiplicity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8, 20),
        () -> test(new int[]{1, 1, 2, 2, 2, 2,}, 5, 12)
    );
  }

  private void test(int[] array, int target, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.threeSumMulti(array, target);
    // then
    assertEquals(expected, actual);
  }
}