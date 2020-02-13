package io.lcalmsky.leetcode.sliding_window_maximum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumTests {
    @Test
    public void givenArray_whenFindMaximumWhileSliding_thenCorrect() {
        assertAll(
                () -> test(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3, new int[]{3, 3, 5, 5, 6, 7}),
                () -> test(new int[]{}, 0, new int[]{}),
                () -> test(new int[]{1, -1}, 1, new int[]{1, -1}),
                () -> test(new int[]{7, 2, 4}, 2, new int[]{7, 4})
        );
    }

    private void test(int[] given, int k, int[] expected) {
        // when
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        int[] actual = slidingWindowMaximum.maxSlidingWindow(given, k);

        // then
        assertArrayEquals(expected, actual);
    }
}
