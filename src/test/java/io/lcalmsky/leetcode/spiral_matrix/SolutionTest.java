package io.lcalmsky.leetcode.spiral_matrix;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenMatrix_whenMakeListInSpiralOrder_thenCorrect() {
        assertAll(
                () -> test(
                        new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                () -> test(
                        new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}
                        },
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
        );
    }

    private void test(int[][] given, List<Integer> expected) {
        // when
        Solution solution = new Solution();
        List<Integer> actual = solution.spiralOrder(given);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}