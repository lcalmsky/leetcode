package io.lcalmsky.leetcode.split_array_into_consecusive_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SplitArrayIntoConsecutiveSubsequenceTest {
    @Test
    public void givenArray_whenSplitArrayIntoConsecutiveSubsequence_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 3, 4, 5}, true),
                () -> test(new int[]{1, 2, 3, 3, 4, 4, 5, 5}, true),
                () -> test(new int[]{1, 2, 3, 4, 4, 5}, false)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        SplitArrayIntoConsecutiveSubsequence splitArrayIntoConsecutiveSubsequence = new SplitArrayIntoConsecutiveSubsequence();
        boolean actual = splitArrayIntoConsecutiveSubsequence.isPossible(given);

        // then
        assertEquals(expected, actual);
    }
}
