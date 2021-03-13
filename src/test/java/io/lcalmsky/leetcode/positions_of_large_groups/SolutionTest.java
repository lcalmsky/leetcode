package io.lcalmsky.leetcode.positions_of_large_groups;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenString_whenFindLargeGroup_thenCorrect() {
        assertAll(
                () -> test("abbxxxxzyy", Collections.singletonList(Arrays.asList(3, 6))),
                () -> test("abc", Collections.emptyList()),
                () -> test("abcdddeeeeaabbbcd", Arrays.asList(Arrays.asList(3, 5), Arrays.asList(6, 9), Arrays.asList(12, 14))),
                () -> test("aaa", Collections.singletonList(Arrays.asList(0, 2)))
        );
    }

    private void test(String given, List<List<Integer>> expected) {
        // when
        Solution solution = new Solution();
        List<List<Integer>> actual = solution.largeGroupPositions(given);

        // then
        assertEquals(expected, actual);
    }
}
