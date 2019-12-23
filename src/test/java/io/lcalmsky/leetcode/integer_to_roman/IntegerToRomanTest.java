package io.lcalmsky.leetcode.integer_to_roman;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerToRomanTest {
    @Test
    public void givenNumber_whenConvertToRoman_thenCorrect() {
        assertAll(
                () -> test(3, "III"),
                () -> test(4, "IV"),
                () -> test(9, "IX"),
                () -> test(58, "LVIII"),
                () -> test(1994, "MCMXCIV")
        );
    }

    private void test(int given, String expected) {
        // when
        IntegerToRoman integerToRoman = new IntegerToRoman();
        String actual = integerToRoman.intToRoman(given);

        // then
        assertEquals(expected, actual);
    }
}
