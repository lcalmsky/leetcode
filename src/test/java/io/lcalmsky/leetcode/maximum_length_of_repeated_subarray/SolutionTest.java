package io.lcalmsky.leetcode.maximum_length_of_repeated_subarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTwoIntegerArrays_whenFindMaximumLengthOfSubarrayThatAppearsInBothArrays_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}, 3)
        );
    }

    private void test(int[] A, int[] B, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.findLength(A, B);

        // then
        assertEquals(expected, actual);
    }

}
