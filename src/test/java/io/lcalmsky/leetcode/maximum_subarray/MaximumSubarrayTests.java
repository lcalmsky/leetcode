package io.lcalmsky.leetcode.maximum_subarray;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarrayTests {
    @Test
    @DisplayName("[-2, 1, -3, 4, -1, 2, 1, -5, 4] -> 6")
    public void givenIntArray_whenGetSubArray_thenLargestSum1() {
        // given
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        // when
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(arr);

        // then
        assertEquals(6, result);
    }

    @Test
    @DisplayName("[1] -> 1")
    public void givenIntArray_whenGetSubArray_thenLargestSum2() {
        // given
        int[] arr = new int[]{1};

        // when
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(arr);

        // then
        assertEquals(1, result);
    }

    @Test
    @DisplayName("[-2, 1] -> 1")
    public void givenIntArray_whenGetSubArray_thenLargestSum3() {
        // given
        int[] arr = new int[]{-2, 1};

        // when
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int result = maximumSubarray.maxSubArray(arr);

        // then
        assertEquals(1, result);
    }
}
