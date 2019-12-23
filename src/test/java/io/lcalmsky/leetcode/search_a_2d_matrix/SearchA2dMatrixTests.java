package io.lcalmsky.leetcode.search_a_2d_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchA2dMatrixTests {
    @Test
    public void givenMatrix_whenSearchesTarget_thenReturnsWhetherExists() {
        assertAll(
                () -> test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 3, true),
                () -> test(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 13, false)
        );
    }

    private void test(int[][] givenArray, int givenTarget, boolean expected) {
        // when
        SearchA2dMatrix searchA2dMatrix = new SearchA2dMatrix();
        boolean actual = searchA2dMatrix.searchMatrix(givenArray, givenTarget);

        // then
        assertEquals(expected, actual);
    }
}
