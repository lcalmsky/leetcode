package io.lcalmsky.leetcode.count_primes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountPrimesTests {
    @Test
    public void givenNumber_whenCountPrimes_thenCorrect() {
        assertAll(
                () -> test(10, 4),
                () -> test(2, 0)
        );
    }

    private void test(int given, int expected) {
        // when
        Solution countPrimes = new Solution();
        int actual = countPrimes.countPrimes(given);

        // then
        assertEquals(expected, actual);
    }
}
