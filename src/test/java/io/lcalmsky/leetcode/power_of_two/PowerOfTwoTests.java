package io.lcalmsky.leetcode.power_of_two;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerOfTwoTests {
    @Test
    public void givenNumber_whenCheckIsPowerOfTwo_thenCorrect() {
        assertAll(
                () -> test(1, true),
                () -> test(16, true),
                () -> test(218, false)
        );
    }

    private void test(int given, boolean expected) {
        // when
        Solution powerOfTwo = new Solution();
        boolean actual = powerOfTwo.isPowerOfTwo(given);

        // then
        assertEquals(expected, actual);
    }
}
