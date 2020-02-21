package io.lcalmsky.leetcode.add_digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddDigitsTests {
    @Test
    public void givenDigit_whenAddUntilOneDigit_thenCorrect() {
        assertAll(
                () -> test(38, 2)
        );
    }

    private void test(int given, int expected) {
        // when
        AddDigits addDigits = new AddDigits();
        int actual = addDigits.addDigits(given);

        // then
        assertEquals(expected, actual);
    }
}
