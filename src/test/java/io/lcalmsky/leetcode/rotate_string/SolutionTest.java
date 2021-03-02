package io.lcalmsky.leetcode.rotate_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTwoStrings_whenRotate_thenCorrect() {
        assertAll(
                () -> test("abcde", "cdeab", true),
                () -> test("abcde", "abced", false),
                () -> test("bbbacddceeb", "ceebbbbacdd", true)
        );
    }

    private void test(String A, String B, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.rotateString(A, B);

        // then
        assertEquals(expected, actual);
    }

}
