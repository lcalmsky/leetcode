package io.lcalmsky.leetcode.max_area_of_island;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxAreaOfIslandTest {
    @Test
    public void given2DArray_whenFindMaximumAreaOfIsland_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
                }, 6),
                () -> test(new int[][]{
                        {0, 0, 0, 0, 0, 0, 0, 0}
                }, 0)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution maxAreaOfIsland = new Solution();
        int actual = maxAreaOfIsland.maxAreaOfIsland(given);

        // then
        assertEquals(expected, actual);
    }
}
