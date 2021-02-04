package io.lcalmsky.leetcode.toeplitz_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenMatrix_whenFindMatrixIsToeplitz_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 2, 3, 4},
                        {5, 1, 2, 3},
                        {9, 5, 1, 2}
                }, true)
        );
    }

    private void test(int[][] given, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.isToeplitzMatrix(given);

        // then
        assertEquals(expected, actual);
    }

}