package io.lcalmsky.leetcode.maximum_number_of_balloons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    void givenText_whenFindBalloons_thenCorrect() {
        assertAll(
                () -> test("nlaebolko", 1),
                () -> test("loonbalxballpoon", 2),
                () -> test("leetcode", 0)
        );
    }

    private void test(String given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.maxNumberOfBalloons(given);

        // then
        assertEquals(expected, actual);
    }
}