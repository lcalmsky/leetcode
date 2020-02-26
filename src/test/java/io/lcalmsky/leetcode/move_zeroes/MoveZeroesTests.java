package io.lcalmsky.leetcode.move_zeroes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MoveZeroesTests {
    @Test
    public void givenArray_whenMoveAllZeroToTheEnd_thenCorrect() {
        assertAll(
                () -> test(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(given);

        // then
        assertArrayEquals(expected, given);
    }
}
