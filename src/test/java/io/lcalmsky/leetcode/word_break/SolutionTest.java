package io.lcalmsky.leetcode.word_break;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("leetcode", List.of("leet", "code"), true),
                () -> test("applepenapple", List.of("apple", "pen"), true),
                () -> test("catsandog", List.of("cats", "dog", "sand", "and", "cat"), false)
        );
    }

    private void test(String s, List<String> wordDict, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.wordBreak(s, wordDict);
        // then
        assertEquals(expected, actual);
    }

}