package io.lcalmsky.leetcode.minimum_ascii_delete_sum_for_two_strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTwoStrings_whenFindTheLowestAsciiSumOfDeletedCharactersToMakeTwoStringsEqual_thenCorrect() {
        assertAll(
                () -> test("sea", "eat", 231),
                () -> test("delete", "leet", 403)
        );
    }

    private void test(String s1, String s2, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.minimumDeleteSum(s1, s2);

        // then
        assertEquals(expected, actual);
    }

}
