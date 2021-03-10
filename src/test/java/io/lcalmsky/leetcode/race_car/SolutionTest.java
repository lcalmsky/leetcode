package io.lcalmsky.leetcode.race_car;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenTargetPosition_whenFindLengthOfShortestSequence_thenCorrect() {
        assertAll(
                () -> test(3, 2),
                () -> test(6, 5)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution solution = new Solution();
        int actual = solution.raceCar(given);

        // then
        assertEquals(expected, actual);
    }
}
