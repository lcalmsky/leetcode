package io.lcalmsky.leetcode.rotate_array;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void givenArray_whenRotateKStepsToRight_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
        () -> test(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
    );
  }

  private void test(int[] actual, int k, int[] expected) {
    // when
    Solution solution = new Solution();
    solution.rotate(actual, k);
    // then
    assertArrayEquals(expected, actual);
  }
}