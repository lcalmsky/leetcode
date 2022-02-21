package io.lcalmsky.leetcode.majority_element;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenFindMajorElement_thenCorrect() {
    assertAll(
        () -> test(new int[]{3, 2, 3}, 3),
        () -> test(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution solution = new Solution();
    int actual = solution.majorityElement(given);
    // then
    assertEquals(expected, actual);
  }
}