package io.lcalmsky.leetcode.backspace_string_compare;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTwoStrings_whenBackspace_thenCorrect() {
        assertAll(
                () -> test("ab#c", "ad#c", true),
                () -> test("ab##", "c#d#", true),
                () -> test("a##c", "#a#c", true),
                () -> test("a#c", "b", false)
        );
    }

    private void test(String s, String t, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.backspaceCompare(s, t);

        // then
        assertEquals(expected, actual);
    }
}
