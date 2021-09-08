package io.lcalmsky.leetcode.shifting_letters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenStringAndShifts_whenShiftString_thenCorrect() {
        assertAll(
                () -> test("abc", new int[]{3, 5, 9}, "rpl"),
                () -> test("ruu", new int[]{26, 9, 17}, "rul"),
                () -> test("mkgfzkkuxownxvfvxasy", new int[]{505870226, 437526072, 266740649, 224336793, 532917782, 311122363, 567754492, 595798950, 81520022, 684110326, 137742843, 275267355, 856903962, 148291585, 919054234, 467541837, 622939912, 116899933, 983296461, 536563513}, "wqqwlcjnkphhsyvrkdod")
        );
    }

    private void test(String S, int[] shifts, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.shiftingLetters(S, shifts);

        // then
        assertEquals(expected, actual);
    }
}