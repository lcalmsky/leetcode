package io.lcalmsky.leetcode.spiral_matrix;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpiralMatrixTests {

    @Test
    public void givenMatrix_whenMakeListInSpiralOrder_thenCorrect() {
        assertAll(
                () -> test(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)
                ),
                () -> test(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        },
                        Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
        );
    }

    private void test(int[][] given, List<Integer> expected) {
        // when
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List<Integer> actual = spiralMatrix.spiralOrder(given);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}