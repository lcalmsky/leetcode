package io.lcalmsky.leetcode.subarray_product_less_than_k;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenArray_whenCountNumberOfSubArraysWhereTheProductOfAllElementsIsLessThanK_thenCorrect() {
        assertAll(
                () -> test(new int[]{10, 5, 2, 6}, 100, 8)
        );
    }

    private void test(int[] given, int k, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.numSubarrayProductLessThanK(given, k);

        // then
        assertEquals(expected, actual);
    }
}
