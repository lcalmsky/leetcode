package io.lcalmsky.leetcode.longest_subarray_of_1s_after_deleting_one_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 1, 0, 1}, 3),
                () -> test(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
                () -> test(new int[]{1, 1, 1}, 2)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.longestSubarray(nums);
        // then
        assertEquals(expected, actual);
    }
}