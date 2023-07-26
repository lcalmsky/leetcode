package io.lcalmsky.leetcode.kids_with_the_greatest_number_of_candies;


import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
                () -> test(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
                () -> test(new int[]{12, 1, 12}, 10, List.of(true, false, true))
        );
    }

    private void test(int[] candies, int extraCandies, List<Boolean> expected) {
        Solution solution = new Solution();
        List<Boolean> actual = solution.kidsWithCandies(candies, extraCandies);
        assertEquals(expected, actual);
    }
}