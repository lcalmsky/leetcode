package io.lcalmsky.leetcode.partition_to_k_equal_sum_subsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PartitionToKEqualSumSubsetsTest {
    @Test
    public void givenPositiveNumbersAndK_whenCheckWhetherItsPossibleToDivideIntoSubsetsWithEqualSum_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 3, 2, 3, 5, 2, 1}, 4, true)
        );
    }

    private void test(int[] nums, int k, boolean expected) {
        // when
        Solution partitionToKEqualSumSubsets = new Solution();
        boolean actual = partitionToKEqualSumSubsets.canPartitionKSubsets(nums, k);

        // then
        assertEquals(expected, actual);
    }

}
