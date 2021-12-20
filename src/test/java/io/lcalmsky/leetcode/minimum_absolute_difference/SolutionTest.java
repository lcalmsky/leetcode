package io.lcalmsky.leetcode.minimum_absolute_difference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {
  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{4, 2, 1, 3}, List.of(
            List.of(1, 2),
            List.of(2, 3),
            List.of(3, 4)
        )),
        () -> test(new int[]{1, 3, 6, 10, 15}, List.of(
            List.of(1, 3)
        )),
        () -> test(new int[]{3, 8, -10, 23, 19, -4, -14, 27}, List.of(
            List.of(-14, -10),
            List.of(19, 23),
            List.of(23, 27)
        ))
    );
  }

  private void test(int[] given, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();
    List<List<Integer>> actual = solution.minimumAbsDifference(given);
    // then
    assertEquals(expected, actual);
  }
}