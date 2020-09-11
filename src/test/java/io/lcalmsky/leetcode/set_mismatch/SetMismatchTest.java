package io.lcalmsky.leetcode.set_mismatch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SetMismatchTest {
    @Test
    public void givenArray_whenFindDuplicateAndMissing_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 2, 4}, new int[]{2, 3})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        SetMismatch setMismatch = new SetMismatch();
        int[] actual = setMismatch.findErrorNums(given);

        // then
        assertArrayEquals(expected, actual);
    }

}