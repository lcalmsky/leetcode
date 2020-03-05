package io.lcalmsky.leetcode.range_sum_query_mutable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumArrayTests {
    @Test
    public void givenArray_whenSumAndUpdate_thenCorrect() {
        // given
        int[] given = new int[]{1, 3, 5};

        // when
        NumArray numArray = new NumArray(given);

        // then
        Assertions.assertEquals(9, numArray.sumRange(0, 2));

        numArray.update(1, 2);

        // then
        Assertions.assertEquals(8, numArray.sumRange(0, 2));
    }
}
