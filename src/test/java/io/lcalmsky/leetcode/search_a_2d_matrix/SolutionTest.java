package io.lcalmsky.leetcode.search_a_2d_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void givenMatrix_whenSearchesTarget_thenReturnsWhetherExists() {
        assertAll(
                () -> test(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 13, true),
                () -> test(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 5, true),
                () -> test(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}}, 20, false)
        );
    }

    private void test(int[][] givenArray, int givenTarget, boolean expected) {
        // when
        Solution searchA2dMatrix = new Solution();
        boolean actual = searchA2dMatrix.searchMatrix(givenArray, givenTarget);

        // then
        assertEquals(expected, actual);
    }
}