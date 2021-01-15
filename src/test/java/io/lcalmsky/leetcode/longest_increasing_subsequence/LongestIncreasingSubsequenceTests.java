package io.lcalmsky.leetcode.longest_increasing_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingSubsequenceTests {
    @Test
    public void givenArray_whenFindLIS_thenCorrect() {
        assertAll(
                () -> test(new int[]{10, 9, 2, 5, 3, 7, 101, 18}, 4)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution longestIncreasingSubsequence = new Solution();
        int actual = longestIncreasingSubsequence.lengthOfLIS(given);

        // then
        assertEquals(expected, actual);
    }
}
