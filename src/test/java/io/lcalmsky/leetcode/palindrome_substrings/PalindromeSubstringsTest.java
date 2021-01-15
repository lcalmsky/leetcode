package io.lcalmsky.leetcode.palindrome_substrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromeSubstringsTest {
    @Test
    public void givenString_whenFindSubstringsArePalindrome_thenCorrect() {
        assertAll(
                () -> test("abc", 3),
                () -> test("aaa", 6)
        );
    }

    private void test(String given, int expected) {
        // when
        Solution palindromeSubstrings = new Solution();
        int actual = palindromeSubstrings.countSubstrings(given);

        // then
        assertEquals(expected, actual);
    }
}
