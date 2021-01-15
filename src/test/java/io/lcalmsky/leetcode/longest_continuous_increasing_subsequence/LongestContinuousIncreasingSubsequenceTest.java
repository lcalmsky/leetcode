package io.lcalmsky.leetcode.longest_continuous_increasing_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestContinuousIncreasingSubsequenceTest {
    @Test
    public void givenNumbers_whenFindLongestContinuousIncreasingSubsequence_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 5, 4, 7}, 3),
                () -> test(new int[]{2, 2, 2, 2, 2}, 1)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution longestContinuousIncreasingSubsequence = new Solution();
        int actual = longestContinuousIncreasingSubsequence.findLengthOfLCIS(given);

        // then
        assertEquals(expected, actual);

    }

}
