package io.lcalmsky.leetcode.next_greater_element_i;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    void givenTwoArrays_whenFindNextGreaterElement_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                () -> test(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1})
        );
    }

    private void test(int[] nums1, int[] nums2, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.nextGreaterElement(nums1, nums2);
        // then
        assertArrayEquals(expected, actual);
    }
}