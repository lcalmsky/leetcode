package io.lcalmsky.leetcode.is_subsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsSubsequenceTests {
    @Test
    public void givenTwoStrings_whenFindOneIsSubsequenceOfAnother_thenCorrect() {
        assertAll(
                () -> test("abc", "ahbgdc", true),
                () -> test("axc", "ahbgdc", false)
        );
    }

    private void test(String s, String t, boolean expected) {
        // when
        Solution isSubsequence = new Solution();
        boolean actual = isSubsequence.isSubsequence(s, t);

        // then
        assertEquals(expected, actual);
    }
}
