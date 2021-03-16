package io.lcalmsky.leetcode.push_dominoes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @Test
    public void givenDominoes_whenPush_thenReturnFinalStateCorrectly() {
        assertAll(
                () -> test(".L.R...LR..L..", "LL.RR.LLRRLL.."),
                () -> test("RR.L", "RR.L")
        );
    }

    private void test(String given, String expected) {
        // when
        Solution solution = new Solution();
        String actual = solution.pushDominoes(given);

        // then
        assertEquals(expected, actual);
    }
}