package io.lcalmsky.leetcode.perfect_squares;

import java.util.Arrays;

public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 10001);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.sqrt(n); j++) {
                if (i == j * j) {
                    dp[i] = 1;
                } else if (i > j * j) {
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
                }
            }
        }
        return dp[n];
    }
}

class AnotherSolution extends Solution {
    public int numSquares(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }

        if (n % 8 == 7) {
            return 4;
        }

        if (isSquares(n)) {
            return 1;
        }

        for (int i = 1; i * i < n; i++) {
            if (isSquares(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }

    private boolean isSquares(int n) {
        int rootN = (int) Math.sqrt(n);
        return n == rootN * rootN;
    }
}