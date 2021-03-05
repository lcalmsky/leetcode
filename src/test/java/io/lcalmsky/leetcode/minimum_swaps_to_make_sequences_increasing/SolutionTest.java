package io.lcalmsky.leetcode.minimum_swaps_to_make_sequences_increasing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTwoArrays_whenSwapToMakeSequenceIncreasing_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}, 1)
        );
    }

    private void test(int[] A, int[] B, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.minSwap(A, B);

        // then
        assertEquals(expected, actual);
    }
}
