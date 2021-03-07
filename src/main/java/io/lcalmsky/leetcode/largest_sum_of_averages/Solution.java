package io.lcalmsky.leetcode.largest_sum_of_averages;

public class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[] preSum = new double[n + 1];
        double[] dp = new double[n + 1];
        for (int i = 1; i <= n; ++i) {
            preSum[i] = preSum[i - 1] + A[i - 1];
            dp[i] = preSum[i] / i;
        }

        for (int k = 2; k <= K; k++) {
            double[] dp2 = new double[n + 1];
            System.arraycopy(dp, 0, dp2, 0, n + 1);
            for (int j = k; j <= n; j++) {
                for (int i = k - 1; i < j; i++) {
                    dp2[j] = Math.max(dp2[j], dp[i] + (preSum[j] - preSum[i]) / (j - i));
                }
            }
            dp = dp2;
        }

        return dp[n];
    }
}
