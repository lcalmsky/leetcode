package io.lcalmsky.leetcode.equal_row_and_column_pairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1),
                () -> test(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3)
        );
    }

    private void test(int[][] grid, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.equalPairs(grid);
        // then
        assertEquals(expected, actual);
    }
}