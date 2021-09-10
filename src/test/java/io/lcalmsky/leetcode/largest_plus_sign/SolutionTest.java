package io.lcalmsky.leetcode.largest_plus_sign;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenNbyNBinaryGridAndMines_whenFindLargestPlusSign_thenCorrect() {
        assertAll(
                () -> test(5, new int[][]{{4, 2}}, 2),
                () -> test(5, new int[][]{{4, 1}}, 3),
                () -> test(1, new int[][]{{0, 0}}, 0)
        );
    }

    private void test(int n, int[][] mines, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.orderOfLargestPlusSign(n, mines);

        // then
        assertEquals(expected, actual);
    }
}