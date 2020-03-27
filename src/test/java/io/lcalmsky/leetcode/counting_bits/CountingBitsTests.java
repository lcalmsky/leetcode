package io.lcalmsky.leetcode.counting_bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingBitsTests {
    @Test
    public void givenNumber_whenFindNumberOfOnesInBinary_thenCorrect() {
        assertAll(
                () -> test(2, new int[]{0, 1, 1}),
                () -> test(5, new int[]{0, 1, 1, 2, 1, 2})
        );
    }

    private void test(int given, int[] expected) {
        // when
        CountingBits countingBits = new CountingBits();
        int[] actual = countingBits.countBits(given);

        // expected
        assertArrayEquals(expected, actual);
    }
}
