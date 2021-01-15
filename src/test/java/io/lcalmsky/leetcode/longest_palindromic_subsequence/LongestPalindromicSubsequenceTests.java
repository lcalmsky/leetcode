package io.lcalmsky.leetcode.longest_palindromic_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestPalindromicSubsequenceTests {
    @Test
    public void givenString_whenFindLongestPalindrome_thenCorrect() {
        assertAll(
                () -> test("bbbab", 4),
                () -> test("cbbd", 2)
        );
    }

    private void test(String given, int expected) {
        // when
        Solution longestPalindromicSubsequence = new Solution();
        int actual = longestPalindromicSubsequence.longestPalindromeSubseq(given);

        // then
        assertEquals(expected, actual);
    }
}
