package io.lcalmsky.leetcode.minimum_moves_to_equal_array_elements_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenArray_whenFindMinimumMovesToEqualsArrayElements_thenCorrect() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, 2),
        () -> test(new int[]{1, 10, 2, 9}, 16)
    );
  }

  private void test(int[] given, int expected) {
    // when
    Solution minimumMovesToEqualsArrayElements2 = new Solution();
    int actual = minimumMovesToEqualsArrayElements2.minMoves2(given);

    // then
    assertEquals(expected, actual);
  }
}