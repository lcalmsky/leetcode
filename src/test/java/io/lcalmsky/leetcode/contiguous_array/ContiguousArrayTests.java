package io.lcalmsky.leetcode.contiguous_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContiguousArrayTests {
    @Test
    public void givenNumbers_whenFindTheMaximumLengthOfAContiguousSubarray_thenCorrect() {
        assertAll(
                () -> test(new int[]{0, 1}, 2),
                () -> test(new int[]{0, 1, 0}, 2)
        );
    }

    private void test(int[] given, int expected) {
        // when
        ContiguousArray contiguousArray = new ContiguousArray();
        int actual = contiguousArray.findMaxLength(given);

        // then
        assertEquals(expected, actual);
    }
}
