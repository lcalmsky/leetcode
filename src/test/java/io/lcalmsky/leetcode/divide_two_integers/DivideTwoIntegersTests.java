package io.lcalmsky.leetcode.divide_two_integers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivideTwoIntegersTests {

    @Test
    public void testSuite() {
        Assertions.assertAll(
                () -> test(10, 3, 3),
                () -> test(7, -3, -2),
                () -> test(-1, -1, 1),
                () -> test(-2147483648, -1, 2147483647),
                () -> test(-2147483648, 1, -2147483648),
                () -> test(-2147483647, 2, -1073741823)
        );
    }

    public void test(int givenDividend, int givenDivisor, int expected) {
        // when
        Solution divideTwoIntegers = new Solution();
        int actual = divideTwoIntegers.divide(givenDividend, givenDivisor);

        // then
        assertEquals(expected, actual);
    }
}
