package io.lcalmsky.leetcode.all_paths_from_source_to_target;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenDirectedAcyclicGraph_whenFindAllPaths_thenCorrect() {
        assertAll(
                () -> test(new int[][]{
                                {1, 2},
                                {3},
                                {3},
                                {}
                        },
                        Arrays.asList(
                                Arrays.asList(0, 1, 3),
                                Arrays.asList(0, 2, 3)
                        ))
        );
    }

    private void test(int[][] given, List<List<Integer>> expected) {
        // when
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.allPathsSourceTarget(given);

        // then
        assertEquals(expected, actual);
    }
}