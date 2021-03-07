package io.lcalmsky.leetcode.largest_sum_of_averages;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void test() {
        // given
        int[] A = {9, 1, 2, 3, 9};
        int K = 3;

        // when
        Solution solution = new Solution();
        double actual = solution.largestSumOfAverages(A, K);

        // then
        assertEquals(20, actual);
    }
}
