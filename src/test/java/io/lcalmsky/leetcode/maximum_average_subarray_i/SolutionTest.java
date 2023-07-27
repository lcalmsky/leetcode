package io.lcalmsky.leetcode.maximum_average_subarray_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75000),
                () -> test(new int[]{5}, 1, 5.00000)
        );
    }

    private void test(int[] nums, int k, double expected) {
        // when
        Solution solution = new Solution();
        double actual = solution.findMaxAverage(nums, k);
        // then
        assertEquals(expected, actual);
    }

}