package io.lcalmsky.leetcode.break_a_palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenPalindrome_whenReplaceOneCharacter_thenBreakPalindrome() {
        assertAll(
                () -> test("abccba", "aaccba"),
                () -> test("a", ""),
                () -> test("aa", "ab"),
                () -> test("aba", "abb")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.breakPalindrome(given);

        // then
        assertEquals(expected, actual);
    }
}