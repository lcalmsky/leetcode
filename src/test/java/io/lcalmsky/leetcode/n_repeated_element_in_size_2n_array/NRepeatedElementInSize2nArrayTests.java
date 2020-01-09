package io.lcalmsky.leetcode.n_repeated_element_in_size_2n_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NRepeatedElementInSize2nArrayTests {
    @Test
    public void givenArray_whenFindRepeatedElement_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 3}, 3),
                () -> test(new int[]{2, 1, 2, 5, 3, 2}, 2),
                () -> test(new int[]{5, 1, 5, 2, 5, 3, 5, 4}, 5)
        );
    }

    private void test(int[] given, int expected) {
        // when
        NRepeatedElementInSize2nArray nRepeatedElementInSize2nArray = new NRepeatedElementInSize2nArray();
        int actual = nRepeatedElementInSize2nArray.repeatedNTimes(given);

        // then
        assertEquals(expected, actual);
    }
}
