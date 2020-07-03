package io.lcalmsky.leetcode.diagonal_traverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DiagonalTraverseTests {
    @Test
    public void givenTwoDimensionArray_whenTraverseInDiagonalWay_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9})
        );
    }

    private void test(int[][] given, int[] expected) {
        // when
        DiagonalTraverse diagonalTraverse = new DiagonalTraverse();
        int[] actual = diagonalTraverse.findDiagonalOrder(given);

        // then
        assertArrayEquals(expected, actual);
    }
}
