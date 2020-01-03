package io.lcalmsky.leetcode.distinct_subsequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistinctSubsequencesTests {
    @Test
    public void givenTwoString_whenFindNumberOfDistinctSubsequences_thenCorrect() {
        assertAll(
                () -> test("rabbbit", "rabbit", 3),
                () -> test("babgbag", "bag", 5)
        );
    }

    private void test(String s, String t, int expected) {
        // when
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        int actual = distinctSubsequences.numDistinct(s, t);

        // then
        assertEquals(expected, actual);
    }
}
