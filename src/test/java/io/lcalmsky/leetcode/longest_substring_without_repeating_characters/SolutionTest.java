package io.lcalmsky.leetcode.longest_substring_without_repeating_characters;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("abcabcbb", 3),
                () -> test("bbbbb", 1),
                () -> test("dvdf", 3),
                () -> test("pwwkew", 3)
        );
    }

    private void test(String s, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.lengthOfLongestSubstring(s);
        // then
        assertEquals(expected, actual);
    }
}