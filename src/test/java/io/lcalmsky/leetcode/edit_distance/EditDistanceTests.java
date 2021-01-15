package io.lcalmsky.leetcode.edit_distance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EditDistanceTests {
    @Test
    public void givenWords_whenEditDistance_thenGetMinimumValue() {
        assertAll(
                () -> test("horse", "ros", 3),
                () -> test("intention", "execution", 5),
                () -> test("distance", "springbok", 9)
        );
    }

    private void test(String givenWord1, String givenWord2, int expected) {
        // when
        Solution editDistance = new Solution();
        int actual = editDistance.minDistance(givenWord1, givenWord2);

        // then
        assertEquals(expected, actual);

        // log
        System.out.println(actual);
    }
}
