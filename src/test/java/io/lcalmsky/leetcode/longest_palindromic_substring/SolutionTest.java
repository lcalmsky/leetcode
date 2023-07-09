package io.lcalmsky.leetcode.longest_palindromic_substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test("babad", "bab"),
                () -> test("cbbd", "bb"),
                () -> test("a", "a"),
                () -> test("ac", "a"),
                () -> test("ccc", "ccc")
        );
    }

    private void test(String s, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.longestPalindrome(s);
        // then
        assertEquals(expected,  actual);
    }
}