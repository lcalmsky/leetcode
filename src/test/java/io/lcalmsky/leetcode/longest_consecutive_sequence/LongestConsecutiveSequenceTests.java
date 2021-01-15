package io.lcalmsky.leetcode.longest_consecutive_sequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestConsecutiveSequenceTests {
    @Test
    public void givenArray_whenGetLongestConsecutiveSequence_thenCorrect() {
        assertAll(
                () -> test(new int[]{100, 4, 200, 1, 3, 2}, 4)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution longestConsecutiveSequence = new Solution();
        int actual = longestConsecutiveSequence.longestConsecutive(given);

        // then
        assertEquals(expected, actual);
    }
}
