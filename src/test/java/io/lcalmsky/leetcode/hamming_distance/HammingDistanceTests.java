package io.lcalmsky.leetcode.hamming_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HammingDistanceTests {
    @Test
    public void givenNumbers_whenFindHammingDistance_thenCorrect() {
        assertAll(
                () -> test(1, 4, 2)
        );
    }

    private void test(int x, int y, int expected) {
        // when
        HammingDistance hammingDistance = new HammingDistance();
        int actual = hammingDistance.hammingDistance(x, y);

        // then
        assertEquals(expected, actual);
    }
}
