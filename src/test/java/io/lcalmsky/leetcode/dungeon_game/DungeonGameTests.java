package io.lcalmsky.leetcode.dungeon_game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DungeonGameTests {
    @Test
    public void givenArray_whenFindMinimumHp_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                        {-2, -3, 3},
                        {-5, -10, 1},
                        {10, 30, -5}
                }, 7)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        DungeonGame dungeonGame = new DungeonGame();
        int actual = dungeonGame.calculateMinimumHp(given);

        // then
        assertEquals(expected, actual);
    }
}
