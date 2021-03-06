package io.lcalmsky.leetcode.find_eventual_safe_states;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenDirectedGraph_whenFindEventualSafeStates_thenCorrect() {
        assertAll(
                () -> test(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}, Arrays.asList(2, 4, 5, 6)),
                () -> test(new int[][]{{1, 2, 3, 4}, {1, 2}, {3, 4}, {0, 4}, {}}, Collections.singletonList(4))
        );
    }

    private void test(int[][] given, List<Integer> expected) {
        // when
        Solution solution = new Solution();
        List<Integer> actual = solution.eventualSafeNodes(given);

        // then
        assertEquals(expected, actual);
    }
}
