package io.lcalmsky.leetcode.super_ugly_number;

/*
Input: n = 12, primes = [2,7,13,19]
Output: 32
Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
             super ugly numbers given primes = [2,7,13,19] of size 4.
 */

public class SuperUglyNumber {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] times = new int[primes.length];
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, primes[j] * result[times[j]]);
            }
            result[i] = min;
            for (int j = 0; j < times.length; j++) {
                if (result[times[j]] * primes[j] == min) {
                    times[j]++;
                }
            }
        }

        return result[n - 1];
    }
}
