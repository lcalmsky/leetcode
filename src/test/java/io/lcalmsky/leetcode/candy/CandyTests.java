package io.lcalmsky.leetcode.candy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CandyTests {
    @Test
    public void givenRatings_whenAllocateCandies_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 0, 2}, 5),
                () -> test(new int[]{1, 2, 2}, 4)
        );
    }

    private void test(int[] given, int expected) {
        // when
        Solution candy = new Solution();
        int actual = candy.candy(given);

        // then
        assertEquals(expected, actual);
    }
}
