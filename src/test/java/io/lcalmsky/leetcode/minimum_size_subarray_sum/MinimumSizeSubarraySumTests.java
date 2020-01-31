package io.lcalmsky.leetcode.minimum_size_subarray_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumSizeSubarraySumTests {
    @Test
    public void givenNumberAndArray_whenFindMinimumSizeSubarrayIndices_thenCorrect() {
        assertAll(
                () -> test(7, new int[]{2, 3, 1, 2, 4, 3}, 2)
        );
    }

    private void test(int s, int[] nums, int expected) {
        // when
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int actual = minimumSizeSubarraySum.minSubArrayLen(s, nums);

        // then
        assertEquals(expected, actual);
    }
}
