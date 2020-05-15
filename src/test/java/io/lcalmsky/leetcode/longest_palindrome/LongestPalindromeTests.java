package io.lcalmsky.leetcode.longest_palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromeTests {
    @Test
    public void givenString_whenFindLongestPalindrome_thenCorrect() {
        assertAll(
                () -> test("abccccdd", 7)
        );
    }

    private void test(String given, int expected) {
        // when
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        int actual = longestPalindrome.longestPalindrome(given);

        // then
        assertEquals(expected, actual);
    }
}
