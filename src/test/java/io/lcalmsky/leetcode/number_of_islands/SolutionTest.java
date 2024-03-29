package io.lcalmsky.leetcode.number_of_islands;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

  @Test
  public void givenGrid_whenFindIslands_thenCountThemExactly() {
    assertAll(
        () -> test(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
        }, 1),
        () -> test(new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'},
        }, 3)
    );
  }

  private void test(char[][] given, int expected) {
    // when
    Solution numberOfIslands = new Solution();
    int actual = numberOfIslands.numIslands(given);

    // then
    assertEquals(expected, actual);
  }
}