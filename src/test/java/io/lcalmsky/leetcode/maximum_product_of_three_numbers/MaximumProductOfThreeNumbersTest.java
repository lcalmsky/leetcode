package io.lcalmsky.leetcode.maximum_product_of_three_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumProductOfThreeNumbersTest {
    @Test
    public void givenArray_whenFindMaximumProductOfThreeNumbers_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3}, 6),
                () -> test(new int[]{1, 2, 3, 4}, 24),
                () -> test(new int[]{-4, -3, -2, -1, 60}, 720)
        );
    }

    private void test(int[] given, int expected) {
        // when
        MaximumProductOfThreeNumbers maximumProductOfThreeNumbers = new MaximumProductOfThreeNumbers();
        int actual = maximumProductOfThreeNumbers.maximumProduct(given);

        // then
        assertEquals(expected, actual);
    }
}