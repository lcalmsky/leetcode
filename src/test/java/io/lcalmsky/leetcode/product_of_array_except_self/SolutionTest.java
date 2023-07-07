package io.lcalmsky.leetcode.product_of_array_except_self;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
                () -> test(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0})
        );
    }

    private void test(int[] nums, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.productExceptSelf(nums);
        // then
        assertArrayEquals(expected, actual);
    }
}
