package io.lcalmsky.leetcode.number_of_longest_increasing_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberOfLongestIncreasingSubsequenceTest {
    @Test
    public void givenNumbers_whenFindLongestIncreasingSubsequenceCounts_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 5, 4, 7}, 2),
                () -> test(new int[]{2, 2, 2, 2, 2}, 5)
        );
    }

    private void test(int[] given, int expected) {
        // when
        NumberOfLongestIncreasingSubsequence numberOfLongestIncreasingSubsequence = new NumberOfLongestIncreasingSubsequence();
        int actual = numberOfLongestIncreasingSubsequence.findNumberOfLIS(given);

        // then
        assertEquals(expected, actual);
    }
}
