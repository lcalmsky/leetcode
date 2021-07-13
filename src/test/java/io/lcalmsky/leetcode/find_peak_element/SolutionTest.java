package io.lcalmsky.leetcode.find_peak_element;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution;

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 1}, 2),
                () -> test(new int[]{1, 2, 1, 3, 5, 6, 4}, 5)
        );
    }

    private void test(int[] nums, int expected) {
        // when
        solution = new Solution();
        int actual = solution.findPeakElement(nums);

        // then
        assertEquals(expected, actual);
    }

}