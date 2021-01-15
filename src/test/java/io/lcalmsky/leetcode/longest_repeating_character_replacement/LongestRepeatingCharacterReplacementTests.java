package io.lcalmsky.leetcode.longest_repeating_character_replacement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestRepeatingCharacterReplacementTests {
    @Test
    public void givenCharacters_whenReplace_thenFindMaximumValueOfRepeatingCount() {
        assertAll(
                () -> test("ABAB", 2, 4),
                () -> test("AABABBA", 1, 4)
        );
    }

    private void test(String s, int k, int expected) {
        // when
        Solution longestRepeatingCharacterReplacement = new Solution();
        int actual = longestRepeatingCharacterReplacement.characterReplacement(s, k);

        // then
        assertEquals(expected, actual);
    }
}
