package io.lcalmsky.leetcode.maximum_average_subarray_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAverageSubarray1Test {
    @Test
    public void givenArrayAndK_whenFindMaxAverageOfSubarray_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75d)
        );
    }

    private void test(int[] given, int k, double expected) {
        // when
        MaximumAverageSubarray1 maximumAverageSubarray1 = new MaximumAverageSubarray1();
        double actual = maximumAverageSubarray1.findMaxAverage(given, k);

        // then
        assertEquals(expected, actual);
    }
}