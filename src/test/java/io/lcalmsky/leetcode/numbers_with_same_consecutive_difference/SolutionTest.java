package io.lcalmsky.leetcode.numbers_with_same_consecutive_difference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(3, 7, new int[]{181, 292, 707, 818, 929}),
        () -> test(2, 1,
            new int[]{10, 12, 21, 23, 32, 34, 43, 45, 54, 56, 65, 67, 76, 78, 87, 89, 98})
    );
  }

  private void test(int n, int k, int[] expected) {
    // when
    Solution solution = new Solution();
    int[] actual = solution.numsSameConsecDiff(n, k);
    // then
    Arrays.sort(actual);
    Arrays.sort(expected);
    assertArrayEquals(expected, actual);
  }

}