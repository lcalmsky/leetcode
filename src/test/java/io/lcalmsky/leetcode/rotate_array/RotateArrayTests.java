package io.lcalmsky.leetcode.rotate_array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RotateArrayTests {
    @Test
    public void givenArray_whenRotateKStepsToRight_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                () -> test(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }

    private void test(int[] actual, int k, int[] expected) {
        // when
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(actual, k);

        // then
        assertArrayEquals(expected, actual);
    }
}
