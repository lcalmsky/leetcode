package io.lcalmsky.leetcode.triangle;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {
    @Test
    public void givenTriangle_whenFindMinimumSum_thenCorrect() {
        assertAll(
                () -> test(Arrays.asList(
                        Collections.singletonList(2),
                        Arrays.asList(3, 4),
                        Arrays.asList(6, 5, 7),
                        Arrays.asList(4, 1, 8, 3)
                ), 11)
        );
    }

    private void test(List<List<Integer>> given, int expected) {
        // when
        Solution triangle = new Solution();
        int actual = triangle.minimumTotal(given);

        // then
        assertEquals(expected, actual);
    }
}
