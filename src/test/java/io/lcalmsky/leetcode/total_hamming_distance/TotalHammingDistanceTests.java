package io.lcalmsky.leetcode.total_hamming_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TotalHammingDistanceTests {
    @Test
    public void givenNumbers_whenFindTotalHammingDistance_thenCorrect() {
        assertAll(
                () -> test(new int[]{4, 14, 2}, 6)
        );
    }

    private void test(int[] given, int expected) {
        // when
        TotalHammingDistance totalHammingDistance = new TotalHammingDistance();
        int actual = totalHammingDistance.totalHammingDistance(given);

        // then
        assertEquals(expected, actual);
    }
}