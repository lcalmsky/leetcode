package io.lcalmsky.leetcode.minimum_time_difference;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinimumTimeDifferenceTests {
    @Test
    public void givenTimeArray_whenFindMinimumTimeDifference_thenCorrect() {
        assertAll(
                () -> test(Arrays.asList("23:59", "00:00"), 1)
        );
    }

    private void test(List<String> given, int expected) {
        // when
        MinimumTimeDifference minimumTimeDifference = new MinimumTimeDifference();
        int actual = minimumTimeDifference.findMinDifference(given);

        // then
        assertEquals(expected, actual);
    }
}
