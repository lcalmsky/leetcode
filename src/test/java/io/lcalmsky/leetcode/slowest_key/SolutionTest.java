package io.lcalmsky.leetcode.slowest_key;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenKeysAndTimes_whenReturnKeyOfLongestDuration_thenCorrect() {
        assertAll(
                () -> test(new int[]{9, 29, 49, 50}, "cbcd", 'c'),
                () -> test(new int[]{12, 23, 36, 46, 62}, "spuda", 'a')
        );
    }

    private void test(int[] releasedTimes, String keysPressed, char expected) {
        // when
        Solution solution = new Solution();
        char actual = solution.slowestKey(releasedTimes, keysPressed);

        // then
        assertEquals(expected, actual);
    }
}