package io.lcalmsky.leetcode.arithmetic_slices;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArithmeticSlicesTests {
    @Test
    public void givenArray_whenSplit_thenArithmeticSlices() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4}, 3)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution arithmeticSlices = new Solution();
        int actual = arithmeticSlices.numberOfArithmeticSlices(given);

        // then
        assertEquals(expected, actual);
    }
}
