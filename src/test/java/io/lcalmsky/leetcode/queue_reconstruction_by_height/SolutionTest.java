package io.lcalmsky.leetcode.queue_reconstruction_by_height;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenQueue_whenReconstruction_thenOrderedByHeightCorrectly() {
    assertAll(
        () -> test(
            new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}},
            new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}
        )
    );
  }

  private void test(int[][] given, int[][] expected) {
    // when
    Solution queueReconstructionByHeight = new Solution();
    int[][] actual = queueReconstructionByHeight.reconstructQueue(given);
    // then
    assertArrayEquals(expected, actual);
  }
}