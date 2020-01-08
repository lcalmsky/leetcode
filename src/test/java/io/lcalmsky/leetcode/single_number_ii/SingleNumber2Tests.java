package io.lcalmsky.leetcode.single_number_ii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleNumber2Tests {
    @Test
    public void givenArray_whenFindSingleNumberWithoutAdditionalMemory_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 2, 3, 2}, 3),
                () -> test(new int[]{0, 1, 0, 1, 0, 1, 99}, 99)
        );
    }

    private void test(int[] given, int expected) {
        // when
        SingleNumber2 singleNumber2 = new SingleNumber2();
        int actual = singleNumber2.singleNumber(given);

        // then
        assertEquals(expected, actual);
    }
}
