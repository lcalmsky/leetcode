package io.lcalmsky.leetcode.convert_a_number_to_hexadecimal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConvertANumberToHexadecimalTests {
    @Test
    public void givenNumber_whenConvertToHexadecimal_thenCorrect() {
        assertAll(
                () -> test(26, "1a"),
                () -> test(-1, "ffffffff")
        );
    }

    private void test(int given, String expected) {
        // when
        ConvertANumberToHexadecimal convertANumberToHexadecimal = new ConvertANumberToHexadecimal();
        String actual = convertANumberToHexadecimal.toHex(given);

        // then
        assertEquals(expected, actual);
    }
}
