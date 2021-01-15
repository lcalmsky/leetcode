package io.lcalmsky.leetcode.word_pattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordPatternTests {
    @Test
    public void givenPatternAndWords_whenCheckPattern_thenCorrect() {
        assertAll(
                () -> test("abba", "dog cat cat dog", true),
                () -> test("abba", "dog cat cat fish", false),
                () -> test("aaaa", "dog cat cat dog", false),
                () -> test("abba", "dog dog dog dog", false)
        );
    }

    private void test(String pattern, String words, boolean expected) {
        // when
        Solution wordPattern = new Solution();
        boolean actual = wordPattern.wordPattern(pattern, words);

        // then
        assertEquals(expected, actual);
    }
}
