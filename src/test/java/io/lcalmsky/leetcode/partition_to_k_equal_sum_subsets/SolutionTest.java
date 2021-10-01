package io.lcalmsky.leetcode.partition_to_k_equal_sum_subsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenPositiveNumbersAndK_whenCheckWhetherItsPossibleToDivideIntoSubsetsWithEqualSum_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 3, 2, 3, 5, 2, 1}, 4, true),
                () -> test(new int[]{1, 2, 3, 4}, 3, false)
        );
    }

    private void test(int[] nums, int k, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.canPartitionKSubsets(nums, k);

        // then
        assertEquals(expected, actual);
    }
}