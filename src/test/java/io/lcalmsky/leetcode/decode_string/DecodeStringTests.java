package io.lcalmsky.leetcode.decode_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecodeStringTests {
    @Test
    public void givenString_whenDecode_thenCorrect() {
        assertAll(
                () -> test("3[a]2[bc]", "aaabcbc"),
                () -> test("3[a2[c]]", "accaccacc"),
                () -> test("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution decodeString = new Solution();
        String actual = decodeString.decodeString(given);

        // then
        assertEquals(expected, actual);
    }
}
