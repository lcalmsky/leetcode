package io.lcalmsky.leetcode.jump_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JumpGameTests {
    @Test
    public void givenArray_whenJump_thenCorrect() {
        assertAll(
                () -> test(new int[]{2, 3, 1, 1, 4}, true),
                () -> test(new int[]{3, 2, 1, 0, 4}, false)
        );
    }

    public void test(int[] given, boolean expected) {

        // when
        Solution jumpGame = new Solution();

        boolean actual = jumpGame.canJump(given);

        // then
        assertEquals(actual, expected);

    }
}
