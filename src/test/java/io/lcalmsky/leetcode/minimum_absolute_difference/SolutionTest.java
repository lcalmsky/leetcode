package io.lcalmsky.leetcode.minimum_absolute_difference;

import static org.junit.jupiter.api.Assertions.*;

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
        ))
    );
  }

  private void test(int[] given, List<List<Integer>> expected) {
    // when
    Solution solution = new Solution();;
    List<List<Integer>> actual = solution.minimumAbsDifference(given);
    // then
    assertEquals(expected, actual);
  }
}