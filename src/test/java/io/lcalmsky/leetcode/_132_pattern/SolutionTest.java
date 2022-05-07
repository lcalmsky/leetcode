package io.lcalmsky.leetcode._132_pattern;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    Solution solution = new Solution();
    assertAll(
        () -> assertFalse(solution.find132Pattern(new int[]{1, 2, 3, 4})),
        () -> assertTrue(solution.find132Pattern(new int[]{3, 1, 4, 2})),
        () -> assertTrue(solution.find132Pattern(new int[]{-1, 3, 2, 0}))
    );
  }
}