package io.lcalmsky.leetcode.valid_anagram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidAnagramTests {
    @Test
    public void givenStrings_whenCheckAnagram_thenCorrect() {
        assertAll(
                () -> test("anagram", "nagaram", true),
                () -> test("rat", "car", false),
                () -> test("a", "b", false),
                () -> test("a", "ab", false)
        );
    }

    private void test(String s, String t, boolean expected) {
        // when
        ValidAnagram validAnagram = new ValidAnagram();
        boolean actual = validAnagram.isAnagram(s, t);

        // then
        assertEquals(expected, actual);
    }
}
