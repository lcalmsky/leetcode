package io.lcalmsky.leetcode.island_perimeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenMap_whenDeterminePerimeterOfIsland_thenCorrect() {
        assertAll(
                () -> test(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}, 16),
                () -> test(new int[][]{{1}}, 4),
                () -> test(new int[][]{{1, 0}}, 4)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution islandPerimeter = new Solution();
        int actual = islandPerimeter.islandPerimeter(given);

        // then
        assertEquals(expected, actual);
    }
}