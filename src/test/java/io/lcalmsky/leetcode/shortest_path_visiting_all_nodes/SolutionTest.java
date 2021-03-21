package io.lcalmsky.leetcode.shortest_path_visiting_all_nodes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenGraph_whenVisitingAllNodes_thenFindPath() {
        assertAll(
                () -> test(new int[][]{
                        {1, 2, 3,},
                        {0},
                        {0},
                        {0}
                }, 4),
                () -> test(new int[][]{
                        {1},
                        {0, 2, 4},
                        {1, 3, 4},
                        {2},
                        {1, 2}
                }, 4)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.shortestPathLength(given);

        // then
        assertEquals(expected, actual);
    }
}
