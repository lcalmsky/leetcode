package io.lcalmsky.leetcode.binary_number_with_alternating_bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryNumberWithAlternatingBitsTest {
    @Test
    public void givenPositiveNumber_whenCheckWhetherItHasAlternatingBits_thenCorrect() {
        assertAll(
                () -> test(5, true),
                () -> test(7, false),
                () -> test(11, false),
                () -> test(10, true),
                () -> test(3, false)
        );
    }

    private void test(int given, boolean expected) {
        // when
        BinaryNumberWithAlternatingBits binaryNumberWithAlternatingBits = new BinaryNumberWithAlternatingBits();
        boolean actual = binaryNumberWithAlternatingBits.hasAlternatingBits(given);

        // then
        assertEquals(expected, actual);
    }

}