package io.lcalmsky.leetcode.removing_stars_from_a_string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void testAll() {
        assertAll(
                () -> test("leet**cod*e", "lecoe"),
                () -> test("erase*****", "")
        );
    }

    private void test(String s, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.removeStars(s);
        // then
        assertEquals(expected, actual);
    }
}