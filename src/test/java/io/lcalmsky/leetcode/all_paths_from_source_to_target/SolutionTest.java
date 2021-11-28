package io.lcalmsky.leetcode.all_paths_from_source_to_target;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenDirectedAcyclicGraph_whenFindAllPaths_thenCorrect() {
    assertAll(
        () -> test(new int[][]{{1, 2}, {3}, {3}, {}}, List.of(List.of(0, 1, 3), List.of(0, 2, 3))),
        () -> test(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}},
            List.of(List.of(0, 4), List.of(0, 3, 4), List.of(0, 1, 3, 4), List.of(0, 1, 2, 3, 4),
                List.of(0, 1, 4))),
        () -> test(new int[][]{{1}, {}}, List.of(List.of(0, 1))),
        () -> test(new int[][]{{1, 2, 3}, {2}, {3}, {}},
            List.of(List.of(0, 1, 2, 3), List.of(0, 2, 3), List.of(0, 3))),
        () -> test(new int[][]{{1, 3}, {2}, {3}, {}}, List.of(List.of(0, 1, 2, 3), List.of(0, 3)))
    );
  }

  private void test(int[][] given, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.allPathsSourceTarget(given);
    // then
    assertEquals(expected, actual);
  }
}