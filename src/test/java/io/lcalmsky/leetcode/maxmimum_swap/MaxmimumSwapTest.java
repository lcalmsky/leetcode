package io.lcalmsky.leetcode.maxmimum_swap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxmimumSwapTest {
    @Test
    public void givenNumber_whenSwap_thenGetMaximum() {
        assertAll(
                () -> test(2736, 7236),
                () -> test(9973, 9973)
        );
    }

    private void test(int given, int expected) {
        // when
        MaxmimumSwap maxmimumSwap = new MaxmimumSwap();
        int actual = maxmimumSwap.maximumSwap(given);

        // then
        assertEquals(expected, actual);
    }
}
