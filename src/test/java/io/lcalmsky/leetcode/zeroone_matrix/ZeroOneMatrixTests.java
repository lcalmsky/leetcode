package io.lcalmsky.leetcode.zeroone_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ZeroOneMatrixTests {
    @Test
    public void givenMatrix_whenFindDistance_thenCorrect() {
        assertAll(
                () -> test(
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}
                        }, new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}
                        }),
                () -> test(
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {1, 1, 1}
                        }, new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {1, 2, 1}
                        })

        );
    }

    private void test(int[][] given, int[][] expected) {
        // when
        ZeroOneMatrix zeroOneMatrix = new ZeroOneMatrix();
        int[][] actual = zeroOneMatrix.updateMatrix(given);

        // then
        assertArrayEquals(expected, actual);
    }
}
