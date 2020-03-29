package io.lcalmsky.leetcode.power_of_four;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfFourTests {
    @Test
    public void givenNumber_whenCheckNumberIsPowerOfFour_thenCorrect() {
        assertAll(
                () -> test(16, true),
                () -> test(5, false),
                () -> test(-1, false),
                () -> test(0, false),
                () -> test(1, true),
                () -> test(8, false)
        );
    }

    private void test(int given, boolean expected) {
        // when
        PowerOfFour powerOfFour = new PowerOfFour();
        boolean actual = powerOfFour.isPowerOfFour(given);

        // then
        assertEquals(expected, actual);
    }
}
