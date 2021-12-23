package io.lcalmsky.leetcode.course_schedule_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(2, new int[][]{{1, 0}}, new int[]{0, 1}),
        () -> test(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}, new int[]{0, 2, 1, 3}),
        () -> test(1, new int[][]{}, new int[]{0})
    );
  }

  private void test(int numCourses, int[][] prerequisites, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.findOrder(numCourses, prerequisites);
    // then
    Arrays.sort(actual);
    Arrays.sort(expected);
    assertArrayEquals(expected, actual);
  }
}