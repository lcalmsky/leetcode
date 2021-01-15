package io.lcalmsky.leetcode.search_a_2d_matrix_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchA2dMatrix2Tests {
    @Test
    public void given2dMatrix_whenFindTarget_thenReturnsTargetExists() {
        final int[][] matrix = {
                {1, 4, 7, 11, 15},
                {1, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30},
        };
        assertAll(
                () -> test(new int[][]{}, 0, false),
                () -> test(matrix, 5, true),
                () -> test(matrix, 20, false)

        );
    }

    private void test(int[][] matrix, int target, boolean expected) {
        // when
        Solution searchA2dMatrix2 = new Solution();
        boolean actual = searchA2dMatrix2.searchMatrix(matrix, target);

        // then
        assertEquals(expected, actual);
    }
}
