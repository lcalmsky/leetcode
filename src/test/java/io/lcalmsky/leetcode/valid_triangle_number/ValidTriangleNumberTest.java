package io.lcalmsky.leetcode.valid_triangle_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidTriangleNumberTest {
    @Test
    public void givenIntegers_whenMakeTriangles_thenFindValidLengths() {
        assertAll(
                () -> test(new int[]{2, 2, 3, 4}, 3)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution validTriangleNumber = new Solution();
        int actual = validTriangleNumber.triangleNumber(given);

        // then
        assertEquals(expected, actual);
    }
}
