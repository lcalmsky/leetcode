package io.lcalmsky.leetcode.largest_divisible_subset;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 2, 3}, List.of(1, 2)),
        () -> test(new int[]{1, 2, 4, 8}, List.of(1, 2, 4, 8))
    );
  }

  private void test(int[] given, List<Integer> expected) {
    // when
    Solution solution = new Solution();
    List<Integer> actual = solution.largestDivisibleSubset(given);
    // then
    assertEquals(expected, actual);
  }

}