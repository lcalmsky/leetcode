package io.lcalmsky.leetcode.summary_ranges;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    assertAll(
        () -> test(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
        () -> test(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9"))
    );
  }

  private void test(int[] given, List<String> expected) {
    // when
    Solution solution = new Solution();
    List<String> actual = solution.summaryRanges(given);
    // then
    assertEquals(expected, actual);
  }
}