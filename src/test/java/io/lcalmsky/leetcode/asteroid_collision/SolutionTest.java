package io.lcalmsky.leetcode.asteroid_collision;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    @Test
    public void givenAsteroids_whenCollide_thenFindOutTheStateOfTheAsteroids() {
        assertAll(
                () -> test(new int[]{5, 10, -5}, new int[]{5, 10}),
                () -> test(new int[]{8, -8}, new int[]{}),
                () -> test(new int[]{10, 2, -5}, new int[]{10}),
                () -> test(new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2})
        );
    }

    private void test(int[] given, int[] expected) {
        // when
        Solution solution = new Solution();
        int[] actual = solution.asteroidCollision(given);

        // then
        assertArrayEquals(expected, actual);
    }

}
