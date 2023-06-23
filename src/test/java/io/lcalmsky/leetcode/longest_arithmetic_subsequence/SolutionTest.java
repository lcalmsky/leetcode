package io.lcalmsky.leetcode.longest_arithmetic_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test() {
        assertAll(
                () -> test(new int[]{3, 6, 9, 12}, 4),
                () -> test(new int[]{9, 4, 7, 2, 10}, 3),
                () -> test(new int[]{20, 1, 15, 3, 10, 5, 8}, 4)
        );
    }

    private void test(int[] nums, int expected) {
        Solution solution = new Solution();
        int actual = solution.longestArithSeqLength(nums);
        assertEquals(expected, actual);
    }
}