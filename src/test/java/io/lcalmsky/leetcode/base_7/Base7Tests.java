package io.lcalmsky.leetcode.base_7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Base7Tests {
    @Test
    public void givenNumber_whenConvertToBase7_thenCorrect() {
        assertAll(
                () -> test(100, "202"),
                () -> test(-7, "-10")
        );
    }

    private void test(int given, String expected) {
        // when
        Base7 base7 = new Base7();
        String actual = base7.convertToBase7(given);

        // then
        assertEquals(expected, actual);
    }
}
