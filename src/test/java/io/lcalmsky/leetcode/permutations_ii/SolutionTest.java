package io.lcalmsky.leetcode.permutations_ii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{1, 1, 2}, List.of(
            List.of(1, 1, 2),
            List.of(1, 2, 1),
            List.of(2, 1, 1)
        ))
//        () -> test(new int[]{1, 2, 3}, List.of(
//            List.of(1, 2, 3),
//            List.of(1, 3, 2),
//            List.of(2, 1, 3),
//            List.of(2, 3, 1),
//            List.of(3, 1, 2),
//            List.of(3, 2, 1)
//        ))
    );
  }

  private void test(int[] given, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.permuteUnique(given);
    // then
    assertTrue(actual.containsAll(expected));
  }
}