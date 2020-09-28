package io.lcalmsky.leetcode.strange_printer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrangePrinterTest {
    @Test
    public void givenString_whenCountMinimumNumberOfTernsPrinterNeeded_thenCorrect() {
        assertAll(
                () -> test("aaabbb", 2),
                () -> test("aba", 2)
        );
    }

    private void test(String given, int expected) {
        // when
        StrangePrinter strangePrinter = new StrangePrinter();
        int actual = strangePrinter.strangePrinter(given);

        // then
        assertEquals(expected, actual);
    }
}
