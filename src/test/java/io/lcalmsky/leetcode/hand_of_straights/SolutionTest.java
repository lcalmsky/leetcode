package io.lcalmsky.leetcode.hand_of_straights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenCards_whenRearrangeCardsIntoEachGroupSizeIsWAndConsecutive_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3, true),
                () -> test(new int[]{1, 2, 3, 4, 5}, 4, false)
        );
    }

    private void test(int[] hand, int w, boolean expected) {
        // when
        Solution solution = new Solution();
        boolean actual = solution.isNStraightHand(hand, w);

        // then
        assertEquals(expected, actual);
    }
}
