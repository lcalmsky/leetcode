package io.lcalmsky.leetcode.super_ugly_number;

/*
†Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
             super ugly numbers given primes = [2,7,13,19] of size 4.
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuperUglyNumberTests {
    @Test
    public void givenNumberAndPrimes_whenNthSuperUglyNumber_thenCorrect() {
        assertAll(
                () -> test(12, new int[]{2, 7, 13, 19}, 32)
        );
    }

    private void test(int n, int[] primes, int expected) {
        // when
        Solution superUglyNumber = new Solution();
        int actual = superUglyNumber.nthSuperUglyNumber(n, primes);

        // then
        assertEquals(expected, actual);
    }
}
