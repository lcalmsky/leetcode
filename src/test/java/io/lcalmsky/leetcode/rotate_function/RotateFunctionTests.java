package io.lcalmsky.leetcode.rotate_function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateFunctionTests {
    @Test
    public void givenArray_whenRotateAndSum_thenGetMaximumValue() {
        assertAll(
                () -> test(new int[]{4, 3, 2, 6}, 26)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution rotateFunction = new Solution();
        int actual = rotateFunction.maxRotateFunction(given);

        // then
        assertEquals(expected, actual);
    }
}
