package io.lcalmsky.leetcode.maximum_product_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumProductSubarrayTests {
    @Test
    public void givenArray_whenFindMaximumProductSubarray_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 3, -2, 4}, 6),
                () -> test(new int[]{-2, 0, -1}, 0)
        );
    }

    private void test(int[] given, int expected) {
        // when
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        int actual = maximumProductSubarray.maxProduct(given);

        // then
        assertEquals(expected, actual);
    }
}
