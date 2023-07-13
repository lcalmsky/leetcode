package io.lcalmsky.leetcode.longest_increasing_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4),
                () -> test(new int[]{0, 1, 0, 3, 2, 3}, 4),
                () -> test(new int[]{7, 7, 7, 7, 7, 7, 7}, 1)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution2 solution = new Solution2();
        int actual = solution.lengthOfLIS(nums);
        // then
        assertEquals(expected, actual);
    }
}