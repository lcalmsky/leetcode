package io.lcalmsky.leetcode.subarray_sum_equals_k;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubArraySumEqualsKTest {
    @Test
    public void givenArray_whenSubArraySum_thenEqualsK() {
        // given
        int[] given = {1, 1, 1};

        // when
        SubArraySumEqualsK subArraySumEqualsK = new SubArraySumEqualsK();
        int actual = subArraySumEqualsK.subarraySum(given, 2);

        // then
        assertEquals(2, actual);
    }
}