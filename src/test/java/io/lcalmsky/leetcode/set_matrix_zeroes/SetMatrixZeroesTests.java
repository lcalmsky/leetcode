package io.lcalmsky.leetcode.set_matrix_zeroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SetMatrixZeroesTests {

    @Test
    public void givenArray_whenZeroFound_thenChangeCrossLines() {
        assertAll(
                () -> test(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}, new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}),
                () -> test(new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}}, new int[][]{{0, 0, 0, 0}, {0, 4, 5, 0}, {0, 3, 1, 0}})
        );
    }

    private void test(int[][] given, int[][] expected) {
        // when
        Solution setMatrixZeroes = new Solution();
        setMatrixZeroes.setZeroes(given);

        // then
        assertArrayEquals(expected, given);
    }
}
