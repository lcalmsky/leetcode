package io.lcalmsky.leetcode.word_break;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordBreakTests {
    @Test
    public void givenWordAndDictionary_whenBreakWords_thenCorrect() {
        assertAll(
                () -> test("leetcode", Arrays.asList("leet", "code"), true),
                () -> test("applepenapple", Arrays.asList("apple", "pen"), true),
                () -> test("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), false)
        );
    }

    private void test(String s, List<String> wordDict, boolean expected) {
        // when
        WordBreak wordBreak = new WordBreak();
        boolean actual = wordBreak.wordBreak(s, wordDict);

        // then
        assertEquals(expected, actual);
    }
}
