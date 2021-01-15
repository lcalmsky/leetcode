package io.lcalmsky.leetcode.remove_duplicate_letters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveDuplicateLettersTests {
    @Test
    public void givenString_whenRemoveDuplicateLetters_thenCorrect() {
        assertAll(
                () -> test("bcabc", "abc"),
                () -> test("cbacdcbc", "acdb")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution removeDuplicateLetters = new Solution();
        String actual = removeDuplicateLetters.removeDuplicateLetters(given);

        // then
        assertEquals(expected, actual);
    }
}
