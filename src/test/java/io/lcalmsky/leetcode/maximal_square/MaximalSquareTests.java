package io.lcalmsky.leetcode.maximal_square;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximalSquareTests {
    @Test
    public void givenMatrix_whenFindMaximalSquare_thenCorrect() {
        assertAll(
                () -> test(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }, 4),
                () -> test(new char[][]{
                        {'0', '1'}
                }, 1)
        );
    }

    private void test(char[][] matrix, int expected) {
        // when
        MaximalSquare maximalSquare = new MaximalSquare();
        int actual = maximalSquare.maximalSquare(matrix);

        // then
        assertEquals(expected, actual);
    }
}
