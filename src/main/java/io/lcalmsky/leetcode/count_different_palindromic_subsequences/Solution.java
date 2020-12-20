package io.lcalmsky.leetcode.count_different_palindromic_subsequences;

public class Solution {
    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        int[][] dp = new int[len][len];

        char[] chars = S.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;   // Consider the test case "a", "b" "c"...
        }

        for (int distance = 1; distance < len; distance++) {
            for (int i = 0; i < len - distance; i++) {
                int j = i + distance;
                if (chars[i] == chars[j]) {
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && chars[left] != chars[j]) left++;
                    while (left <= right && chars[right] != chars[j]) right--;
                    if (left > right) dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    else if (left == right) dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    else dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];  //s.charAt(i) != s.charAt(j)
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }

        return dp[0][len - 1];
    }
}
