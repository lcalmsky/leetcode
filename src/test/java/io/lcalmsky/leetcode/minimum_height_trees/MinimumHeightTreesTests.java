package io.lcalmsky.leetcode.minimum_height_trees;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumHeightTreesTests {
    @Test
    public void givenEdgesAndNumberOfNodes_whenFindRootNodeWithMinimumHeightTree_thenCorrect() {
        assertAll(
                () -> test(4, new int[][]{{1, 0}, {1, 2}, {1, 3}}, Collections.singletonList(1)),
                () -> test(6, new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}, Arrays.asList(3, 4)),
                () -> test(1, new int[][]{}, Collections.singletonList(0))
        );
    }

    private void test(int n, int[][] edges, List<Integer> expected) {
        // when
        MinimumHeightTrees minimumHeightTrees = new MinimumHeightTrees();
        List<Integer> actual = minimumHeightTrees.findMinHeightTrees(n, edges);

        // then
        assertEquals(expected, actual);
    }
}
