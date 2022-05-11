package io.lcalmsky.leetcode.combination_sum_iii;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenNumberAndSum_whenFindCombinations_thenCorrect() {
    assertAll(
        () -> test(3, 7, List.of(
            List.of(1, 2, 4)
        )),
        () -> test(3, 9, List.of(
            List.of(1, 2, 6),
            List.of(1, 3, 5),
            List.of(2, 3, 4))
        )
    );
  }

  private void test(int k, int n, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.combinationSum3(k, n);
    // then
    assertEquals(expected, actual);
  }
}