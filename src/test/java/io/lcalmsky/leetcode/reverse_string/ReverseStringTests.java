package io.lcalmsky.leetcode.reverse_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseStringTests {
    @Test
    public void givenString_whenReverse_thenCorrect() {
        assertAll(
                () -> test(new char[]{'h', 'e', 'l', 'l', 'o'}, new char[]{'o', 'l', 'l', 'e', 'h'}),
                () -> test(new char[]{'H', 'a', 'n', 'n', 'a', 'h'}, new char[]{'h', 'a', 'n', 'n', 'a', 'H'})
        );
    }

    private void test(char[] given, char[] expected) {
        // when
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(given);

        // then
        assertArrayEquals(expected, given);
    }
}
