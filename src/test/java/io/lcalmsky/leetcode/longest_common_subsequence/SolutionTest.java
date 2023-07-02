package io.lcalmsky.leetcode.longest_common_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("abcde", "ace", 3),
                () -> test("abc", "abc", 3),
                () -> test("abc", "def", 0)
        );
    }

    private void test(String text1, String text2, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.longestCommonSubsequence(text1, text2);
        // then
        assertEquals(expected, actual);
    }
}