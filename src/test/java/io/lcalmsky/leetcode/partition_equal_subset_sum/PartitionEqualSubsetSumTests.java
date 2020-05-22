package io.lcalmsky.leetcode.partition_equal_subset_sum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartitionEqualSubsetSumTests {
    @Test
    public void givenArray_whenSumSubsets_thenEqualsPartition() {
        assertAll(
                () -> test(new int[]{1, 5, 11, 5}, true),
                () -> test(new int[]{1, 2, 3, 4, 5}, false)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        boolean actual = partitionEqualSubsetSum.canPartition(given);

        // then
        assertEquals(expected, actual);
    }
}
