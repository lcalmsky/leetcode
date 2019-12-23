package io.lcalmsky.leetcode.implement_strstr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImplementStrstrTests {

    @Test
    public void givenString_whenNeedleProvided_thenFindIndex() {
        assertAll(
                () -> test("hello", "ll", 2),
                () -> test("aaaaa", "bba", -1)
        );
    }

    private void test(String givenHaystack, String givenNeedle, int expected) {
        // when
        ImplementStrstr implementStrstr = new ImplementStrstr();
        int actual = implementStrstr.strStr(givenHaystack, givenNeedle);

        // then
        assertEquals(expected, actual);
    }
}
