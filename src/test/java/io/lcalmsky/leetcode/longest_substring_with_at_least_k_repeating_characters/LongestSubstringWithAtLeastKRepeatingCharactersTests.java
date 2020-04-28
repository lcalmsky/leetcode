package io.lcalmsky.leetcode.longest_substring_with_at_least_k_repeating_characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestSubstringWithAtLeastKRepeatingCharactersTests {
    @Test
    public void givenString_whenFindLongestSubstringLengthWithConditions_thenCorrect() {
        assertAll(
                () -> test("aaabb", 3, 3),
                () -> test("ababbc", 2, 5)
        );
    }

    private void test(String given, int k, int expected) {
        // when
        LongestSubstringWithAtLeastKRepeatingCharacters longestSubstringWithAtLeastKRepeatingCharacters = new LongestSubstringWithAtLeastKRepeatingCharacters();
        int actual = longestSubstringWithAtLeastKRepeatingCharacters.longestSubstring(given, k);

        // then
        assertEquals(expected, actual);
    }
}
