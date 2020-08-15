package io.lcalmsky.leetcode.reshape_the_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ReshapeTheMatrixTest {
    @Test
    public void givenMatrix_whenReshapeTheMatrix_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                                {1, 2},
                                {3, 4}
                        }, 1, 4,
                        new int[][]{{1, 2, 3, 4}}),
                () -> test(new int[][]{
                                {1, 2},
                                {3, 4}
                        }, 2, 4,
                        new int[][]{
                                {1, 2},
                                {3, 4}
                        })
        );
    }

    private void test(int[][] given, int r, int c, int[][] expected) {
        // when
        ReshapeTheMatrix reshapeTheMatrix = new ReshapeTheMatrix();
        int[][] actual = reshapeTheMatrix.matrixReshape(given, r, c);

        // then
        assertArrayEquals(expected, actual);
    }

}