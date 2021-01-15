package io.lcalmsky.leetcode.interleaving_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterleavingStringTests {
    @Test
    public void givenStrings_whenCheckWhetherInterleaved_thenCorrect() {
        assertAll(
                () -> test("aabcc", "dbbca", "aadbbcbcac", true),
                () -> test("aabcc", "dbbca", "aadbbbaccc", false)
        );
    }

    private void test(String s1, String s2, String s3, boolean expected) {
        // when
        Solution interleavingString = new Solution();
        boolean actual = interleavingString.isInterleave(s1, s2, s3);

        // then
        assertEquals(expected, actual);
    }
}
