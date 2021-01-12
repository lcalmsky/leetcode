package io.lcalmsky.leetcode.student_attendance_record_ii;

/**
 * <pre>
 * Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 *
 * A student attendance record is a string that only contains the following three characters:
 *
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 *
 * Example 1:
 * Input: n = 2
 * Output: 8
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent times.
 * Note: The value of n won't exceed 100,000.
 * </pre>
 */
public class Solution {
    public int checkRecord(int n) {
        int M = 1000000007;
        int[][][] dp = new int[n + 1][2][3];
        for (int j = 0; j < 2; ++j) {
            for (int k = 0; k < 3; ++k) {
                dp[0][j][k] = 1;
            }
        }
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 2; ++j) {
                for (int k = 0; k < 3; ++k) {
                    int val = dp[i - 1][j][2];
                    if (j > 0) val = (val + dp[i - 1][j - 1][2]) % M;
                    if (k > 0) val = (val + dp[i - 1][j][k - 1]) % M;
                    dp[i][j][k] = val;
                }
            }
        }
        return dp[n][1][2];
    }
}
