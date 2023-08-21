package io.lcalmsky.leetcode.rotate_image;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(
                        new int[][]{
                                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
                        },
                        new int[][]{
                                {7, 4, 1}, {8, 5, 2}, {9, 6, 3}
                        }
                ),
                () -> test(
                        new int[][]{
                                {5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
                        },
                        new int[][]{
                                {15, 13, 2, 5}, {14, 3, 4, 1}, {12, 6, 8, 9}, {16, 7, 10, 11}
                        }
                )
        );
    }

    private void test(int[][] matrix, int[][] expected) {
        Solution solution = new Solution();
        solution.rotate(matrix);
        assertArrayEquals(expected, matrix);
    }
}