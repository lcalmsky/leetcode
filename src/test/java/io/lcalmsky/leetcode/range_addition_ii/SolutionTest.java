package io.lcalmsky.leetcode.range_addition_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenMbyNMatrix_whenExecuteOperation_thenFindTheNumberOfMaximumIntegers() {
        assertAll(
                () -> test(3, 3, new int[][]{
                        {2, 2},
                        {3, 3}
                }, 4),
                () -> test(3, 3, new int[][]{
                        {2, 2},
                        {3, 3},
                        {3, 3},
                        {3, 3},
                        {2, 2},
                        {3, 3},
                        {3, 3},
                        {3, 3},
                        {2, 2},
                        {3, 3},
                        {3, 3},
                        {3, 3}
                }, 4),
                () -> test(3, 3, new int[][]{
                }, 9),
                () -> test(18, 3, new int[][]{
                        {16, 1},
                        {14, 3},
                        {14, 2},
                        {4, 1},
                        {10, 1},
                        {11, 1},
                        {8, 3},
                        {16, 2},
                        {13, 1},
                        {8, 3},
                        {2, 2},
                        {9, 1},
                        {3, 1},
                        {2, 2},
                        {6, 3}
                }, 2)
        );
    }

    private void test(int givenM, int givenN, int[][] givenOps, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxCount(givenM, givenN, givenOps);

        // then
        assertEquals(expected, actual);
    }
}