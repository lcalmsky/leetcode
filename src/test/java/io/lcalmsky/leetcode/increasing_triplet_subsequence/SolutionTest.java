package io.lcalmsky.leetcode.increasing_triplet_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4, 5}, true),
                () -> test(new int[]{5, 4, 3, 2, 1}, false),
                () -> test(new int[]{2, 1, 5, 0, 4, 6}, true)
        );
    }

    private void test(int[] nums, boolean expected) {
        Solution solution = new Solution();
        boolean actual = solution.increasingTriplet(nums);
        assertEquals(expected, actual);
    }

}