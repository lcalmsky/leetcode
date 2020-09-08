package io.lcalmsky.leetcode.sum_of_square_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfSquareNumbersTest {
    @Test
    public void givenNonNegativeInteger_whenDecideSumOfSquareNumbers_thenCorrect() {
        assertAll(
                () -> test(5, true),
                () -> test(3, false),
                () -> test(14, false)
        );
    }

    private void test(int given, boolean expected) {
        // when
        SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
        boolean actual = sumOfSquareNumbers.judgeSquareSum(given);

        // then
        assertEquals(expected, actual);
    }
}