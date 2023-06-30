package io.lcalmsky.leetcode.maximum_product_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void test() {
        assertAll(
                () -> test(new int[]{2, 3, -2, 4}, 6),
                () -> test(new int[]{-2, 0, -1}, 0)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxProduct(nums);
        // then
        assertEquals(expected, actual);
    }
}