package io.lcalmsky.leetcode.maximum_xor_of_two_numbers_in_an_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumXorOfTwoNumbersInAnArrayTests {
    @Test
    public void givenArray_whenXor_thenFindMaximum() {
        assertAll(
                () -> test(new int[]{3, 10, 5, 25, 2, 8}, 28)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution maximumXorOfTwoNumbersInAnArray = new Solution();
        int actual = maximumXorOfTwoNumbersInAnArray.findMaximumXOR(given);

        // then
        assertEquals(expected, actual);
    }
}
