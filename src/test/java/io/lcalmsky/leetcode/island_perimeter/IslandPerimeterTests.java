package io.lcalmsky.leetcode.island_perimeter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IslandPerimeterTests {
    @Test
    public void givenMap_whenDeterminePerimeterOfIsland_thenCorrect() {
        assertAll(
                () -> test(new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}}, 16)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        int actual = islandPerimeter.islandPerimeter(given);

        // then
        assertEquals(expected, actual);
    }
}
