package io.lcalmsky.leetcode.russian_doll_envelopes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RussianDollEnvelopesTests {
    @Test
    public void givenPairsOfIntegers_whenEnvelopes_thenGetMaximumCount() {
        assertAll(
                () -> test(new int[][]{
                        {5, 4},
                        {6, 4},
                        {6, 7},
                        {2, 3}
                }, 3)
        );
    }

    private void test(int[][] given, int expected) {
        // when
        RussianDollEnvelopes russianDollEnvelopes = new RussianDollEnvelopes();
        int actual = russianDollEnvelopes.maxEnvelopes(given);

        // then
        assertEquals(expected, actual);
    }
}
