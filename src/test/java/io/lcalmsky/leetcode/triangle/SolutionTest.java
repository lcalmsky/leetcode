package io.lcalmsky.leetcode.triangle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenTriangle_whenFindMinimumSum_thenCorrect() {
    assertAll(
        () -> test(
            List.of(
                Collections.singletonList(2),
                List.of(3, 4),
                List.of(6, 5, 7),
                List.of(4, 1, 8, 3)
            ), 11),
        () -> test(
            List.of(
                Collections.singletonList(-10)
            ), -10)
    );
  }

  private void test(List<List<Integer>> given, int expected) {
    // when
    Solution triangle = new Solution();
    int actual = triangle.minimumTotal(given);

    // then
    assertEquals(expected, actual);
  }
}