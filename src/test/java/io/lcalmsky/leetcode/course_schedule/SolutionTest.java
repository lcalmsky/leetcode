package io.lcalmsky.leetcode.course_schedule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test(2, new int[][]{{1, 0}}, true),
                () -> test(2, new int[][]{{1, 0}, {0, 1}}, false),
                () -> test(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}, true)
        );
    }

    private void test(int numCourses, int[][] prerequisites, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.canFinish(numCourses, prerequisites);
        // then
        assertEquals(expected, actual);
    }

}