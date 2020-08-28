package io.lcalmsky.leetcode.non_negative_integers_without_consecutive_ones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NonNegativeIntegersWithoutConsecutiveOnesTest {
    @Test
    public void givenAPositiveInteger_whenFindNumberOfNonNegativeIntegersDoNotContainsConsecutiveOnes_thenCorrect() {
        assertAll(
                () -> test(5, 5)
        );
    }

    private void test(int given, int expected) {
        // when
        NonNegativeIntegersWithoutConsecutiveOnes nonNegativeIntegersWithoutConsecutiveOnes = new NonNegativeIntegersWithoutConsecutiveOnes();
        int actual = nonNegativeIntegersWithoutConsecutiveOnes.findIntegers(given);

        // then
        assertEquals(expected, actual);
    }

}