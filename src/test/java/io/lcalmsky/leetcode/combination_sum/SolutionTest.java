package io.lcalmsky.leetcode.combination_sum;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{2, 3, 6, 7}, 7, List.of(List.of(2, 2, 3), List.of(7))),
        () -> test(new int[]{2, 3, 5}, 8,
            List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))),
        () -> test(new int[]{2}, 1, List.of())
    );
  }

  private void test(int[] candidates, int target, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.combinationSum(candidates, target);
    // then
    assertTrue(actual.containsAll(expected));
  }
}