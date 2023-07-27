package io.lcalmsky.leetcode.maximum_number_of_vowels_in_a_substring_of_given_length;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void testAll() {
        assertAll(
                () -> test("abciiidef", 3, 3),
                () -> test("aeiou", 2, 2),
                () -> test("leetcode", 3, 2)
        );
    }

    private void test(String s, int k, int expected) {
        // when
        Solution2 solution = new Solution2();
        int actual = solution.maxVowels(s, k);
        // then
        assertEquals(expected, actual);
    }
}