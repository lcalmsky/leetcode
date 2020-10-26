package io.lcalmsky.leetcode._24_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Game24Test {
    @Test
    public void givenNumbers_whenJudgeWhetherCouldOperatedToGetTheValueOf24_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 1, 8, 7}, true),
                () -> test(new int[]{1, 2, 1, 2}, false)
        );
    }

    private void test(int[] given, boolean expected) {
        // when
        Game24 game24 = new Game24();
        boolean actual = game24.judgePoint24(given);

        // then
        assertEquals(expected, actual);
    }
}
