package io.lcalmsky.leetcode.repeated_substring_pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatedSubstringPatternTests {
    @Test
    public void givenString_whenFindSubstringPatternExists_thenCorrect() {
        assertAll(
                () -> test("abab", true),
                () -> test("aba", false),
                () -> test("abcabcabcabc", true)
        );
    }

    private void test(String given, boolean expected) {
        // when
        Solution repeatedSubstringPattern = new Solution();
        boolean actual = repeatedSubstringPattern.repeatedSubstringPattern(given);

        // then
        assertEquals(expected, actual);
    }
}
