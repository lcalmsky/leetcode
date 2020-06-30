package io.lcalmsky.leetcode.reverse_pairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReversePairsTests {
    @Test
    public void givenArray_whenDoImportantReverse_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, 2, 3, 1}, 2),
                () -> test(new int[]{2, 4, 3, 5, 1}, 3)
        );
    }

    private void test(int[] given, int expected) {
        // when
        ReversePairs reversePairs = new ReversePairs();
        int actual = reversePairs.reversePairs(given);

        // then
        assertEquals(expected, actual);
    }
}
