package io.lcalmsky.leetcode.spiral_matrix_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SpiralMatrix2Tests {

    @Test
    public void givenInteger_whenGenerateMatrix_thenCorrect() {
        assertAll(
                () -> test(3, new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}),
                () -> test(4, new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}})
        );
    }

    private void test(int given, int[][] expected) {
        // when
        Solution spiralMatrix2 = new Solution();
        int[][] actual = spiralMatrix2.generateMatrix(given);

        // then
        assertArrayEquals(expected, actual);
    }
}
