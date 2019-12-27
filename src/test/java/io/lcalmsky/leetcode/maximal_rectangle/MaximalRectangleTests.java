package io.lcalmsky.leetcode.maximal_rectangle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximalRectangleTests {
    @Test
    public void givenArray_whenGetMaximalRectangleArea_thenCorrect() {
        assertAll(
                () -> test(new char[][]{
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                }, 6)
        );
    }

    private void test(char[][] given, int expected) {
        // when
        MaximalRectangle maximalRectangle = new MaximalRectangle();
        int actual = maximalRectangle.maximalRectangle(given);

        // then
        assertEquals(expected, actual);
    }
}
