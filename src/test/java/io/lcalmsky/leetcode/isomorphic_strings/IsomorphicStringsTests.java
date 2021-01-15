package io.lcalmsky.leetcode.isomorphic_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsomorphicStringsTests {
    @Test
    public void givenTwoStrings_whenCheckIsomorphic_thenCorrect() {
        assertAll(
                () -> test("egg", "add", true),
                () -> test("foo", "bar", false),
                () -> test("paper", "title", true),
                () -> test("", "", true),
                () -> test("ab", "aa", false)
        );
    }

    private void test(String s, String t, boolean expected) {
        // when
        Solution isomorphicStrings = new Solution();
        boolean actual = isomorphicStrings.isIsomorphic(s, t);

        // then
        assertEquals(expected, actual);
    }
}
