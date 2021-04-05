package io.lcalmsky.leetcode.transpose_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void givenMatrix_whenTranspose_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                }, new int[][]{
                        {1, 4, 7},
                        {2, 5, 8},
                        {3, 6, 9}
                }),
                () -> test(new int[][]{
                        {1, 2, 3},
                        {4, 5, 6}
                }, new int[][]{
                        {1, 4},
                        {2, 5},
                        {3, 6}
                })
        );
    }

    private void test(int[][] given, int[][] expected) {
        // when
        Solution solution = new Solution();
        int[][] actual = solution.transpose(given);

        // then
        assertArrayEquals(expected, actual);
    }
}