package io.lcalmsky.leetcode.max_consecutive_ones_iii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6),
                () -> test(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10)
        );

    }

    private void test(int[] nums, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.longestOnes(nums, k);
        // then
        assertEquals(expected, actual);
    }

}