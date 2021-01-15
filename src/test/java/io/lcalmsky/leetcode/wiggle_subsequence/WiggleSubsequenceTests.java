package io.lcalmsky.leetcode.wiggle_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WiggleSubsequenceTests {
    @Test
    public void givenNumbers_whenFindMaximumLengthOfWiggleSequence_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 7, 4, 9, 2, 5}, 6),
                () -> test(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}, 7),
                () -> test(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution wiggleSubsequence = new Solution();
        int actual = wiggleSubsequence.wiggleMaxLength(given);

        // then
        assertEquals(expected, actual);
    }
}
