package io.lcalmsky.leetcode.k_closest_points_to_origin;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}),
        () -> test(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}})
    );
  }

  private void test(int[][] points, int k, int[][] expected) {
    // when
    Solution solution = new Solution();
    int[][] actual = solution.kClosest(points, k);
    // then
    assertArrayEquals(expected, actual);
  }
}