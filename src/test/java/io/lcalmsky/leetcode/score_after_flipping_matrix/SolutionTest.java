package io.lcalmsky.leetcode.score_after_flipping_matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenMatrix_whenFlippingAndToggle_thenReturnsHighestScore() {
        assertAll(
                () -> test(new int[][]{
                        {0, 0, 1, 1},
                        {1, 0, 1, 0},
                        {1, 1, 0, 0}
                }, 39)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.matrixScore(given);

        // then
        assertEquals(expected, actual);
    }
}
