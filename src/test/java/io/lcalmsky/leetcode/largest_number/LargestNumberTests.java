package io.lcalmsky.leetcode.largest_number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LargestNumberTests {
    @Test
    public void givenArray_whenCombineLargestNumber_thenCorrect() {
        assertAll(
                () -> test(new int[]{10, 2}, "210"),
                () -> test(new int[]{3, 30, 34, 5, 9}, "9534330")
        );
    }

    private void test(int[] given, String expected) {
        // when
        LargestNumber largestNumber = new LargestNumber();
        String actual = largestNumber.largestNumber(given);

        // then
        assertEquals(expected, actual);
    }
}
