package io.lcalmsky.leetcode.non_decreasing_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NonDecreasingArrayTest {
    @Test
    public void givenArray_whenCheckWhetherArrayIsNonDecreasing_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 2, 3}, true),
                () -> test(new int[]{4, 2, 1}, false)
        );
    }

    private void test(int[] nums, boolean expected) {
        // when
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        boolean actual = nonDecreasingArray.checkPossibility(nums);

        // then
        assertEquals(expected, actual);
    }
}
