package io.lcalmsky.leetcode.valid_palindrome_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidPalindrome2Test {
    @Test
    public void givenString_whenCheckTheStringIsPalindrome_thenCorrect() {
        assertAll(
                () -> test("aba", true),
                () -> test("abca", true)
        );
    }

    private void test(String given, boolean expected) {
        // when
        ValidPalindrome2 validPalindrome2 = new ValidPalindrome2();
        boolean actual = validPalindrome2.validPalindrome(given);

        // then
        assertEquals(expected, actual);
    }
}