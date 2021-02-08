package io.lcalmsky.leetcode.reorganize_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenString_whenRearrange_thenCorrect() {
        assertAll(
                () -> test("aab", "aba"),
                () -> test("aaab", "")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.reorganizeString(given);

        // then
        assertEquals(expected, actual);
    }
}
