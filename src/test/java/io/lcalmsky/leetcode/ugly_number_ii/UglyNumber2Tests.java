package io.lcalmsky.leetcode.ugly_number_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UglyNumber2Tests {
    @Test
    public void givenANumber_whenFindNthUglyNumber_thenCorrect() {
        assertAll(
                () -> test(10, 12)
        );
    }

    private void test(int given, int expected) {
        // when
        UglyNumber2 uglyNumber2 = new UglyNumber2();
        int actual = uglyNumber2.nthUglyNumber(given);

        // then
        assertEquals(expected, actual);
    }
}
