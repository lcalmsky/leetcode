package io.lcalmsky.leetcode.robot_bounded_in_circle;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  void testAll() {
    Solution solution = new Solution();
    assertAll(
        () -> assertTrue(solution.isRobotBounded("GGLLGG")),
        () -> assertFalse(solution.isRobotBounded("GG")),
        () -> assertTrue(solution.isRobotBounded("GL"))
    );
  }
}