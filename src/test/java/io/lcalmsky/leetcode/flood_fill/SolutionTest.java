package io.lcalmsky.leetcode.flood_fill;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void given2DArray_whenFloodFill_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                                {1, 1, 1},
                                {1, 1, 0},
                                {1, 0, 1}
                        },
                        1,
                        1,
                        2,
                        new int[][]{
                                {2, 2, 2},
                                {2, 2, 0},
                                {2, 0, 1}
                        })
        );
    }

    private void test(int[][] image, int sr, int sc, int newColor, int[][] expected) {
        // when
        Solution solution = new Solution();
        int[][] actual = solution.floodFill(image, sr, sc, newColor);

        // then
        assertArrayEquals(expected, actual);
    }

}
