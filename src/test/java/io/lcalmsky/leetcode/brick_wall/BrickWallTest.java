package io.lcalmsky.leetcode.brick_wall;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BrickWallTest {
    @Test
    public void givenWall_whenDrawVertical_thenCrossLeastBreaks() {
        assertAll(
                () -> test(Arrays.asList(
                        Arrays.asList(1, 2, 2, 1),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 2),
                        Arrays.asList(2, 4),
                        Arrays.asList(3, 1, 2),
                        Arrays.asList(1, 3, 1, 1)
                ), 2)
        );
    }

    private void test(List<List<Integer>> given, int expected) {
        // when
        BrickWall brickWall = new BrickWall();
        int actual = brickWall.leastBricks(given);

        // then
        assertEquals(expected, actual);
    }
}