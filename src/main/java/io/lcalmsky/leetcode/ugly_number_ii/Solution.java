package io.lcalmsky.leetcode.ugly_number_ii;

public class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        int m2 = 0, m3 = 0, m5 = 0;

        for (int i = 1; i < n; i++) {
            int a = dp[m2] * 2;
            int b = dp[m3] * 3;
            int c = dp[m5] * 5;

            dp[i] = Math.min(a, Math.min(b, c));

            if (dp[i] == a) m2++;
            if (dp[i] == b) m3++;
            if (dp[i] == c) m5++;
        }

        return dp[n - 1];
    }
}
