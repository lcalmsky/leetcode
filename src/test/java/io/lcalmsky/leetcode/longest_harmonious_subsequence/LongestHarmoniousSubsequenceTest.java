package io.lcalmsky.leetcode.longest_harmonious_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestHarmoniousSubsequenceTest {
    @Test
    public void givenArray_whenFindHarmoniousSubsequence_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 2, 2, 5, 2, 3, 7}, 5)
        );
    }

    private void test(int[] given, int expected) {
        // when
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        int actual = longestHarmoniousSubsequence.findLHS(given);

        // then
        assertEquals(expected, actual);
    }
}