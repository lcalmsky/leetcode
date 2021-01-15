package io.lcalmsky.leetcode.max_sum_of_rectangle_no_larger_than_k;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSumOfRectangleNoLargerThanKTests {
    @Test
    public void givenMatrix_findMaxSumOfARectangleNoLargerThanK_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {1, 0, 1},
                        {0, -2, 3}
                }, 2, 2)
        );
    }

    private void test(int[][] given, int k, int expected) {
        // when
        Solution maxSumOfRectangleNoLargerThanK = new Solution();
        int actual = maxSumOfRectangleNoLargerThanK.maxSumSubmatrix(given, k);

        // then
        assertEquals(expected, actual);
    }
}
