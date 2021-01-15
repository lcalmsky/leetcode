package io.lcalmsky.leetcode.first_missing_positive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstMissingPositiveTests {

    @Test
    public void givenIntegerArray_whenFindMissingPositive_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 0}, 3),
                () -> test(new int[]{3, 4, -1, 1}, 2),
                () -> test(new int[]{7, 8, 9, 11, 12}, 1),
                () -> test(new int[]{0, 1, 1, 2, 2}, 3)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution firstMissingPositives = new Solution();
        int actual = firstMissingPositives.firstMissingPositive(given);

        // then
        assertEquals(expected, actual);
    }
}
