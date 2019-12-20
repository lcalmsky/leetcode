package io.lcalmsky.leetcode.edit_distance;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if ((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0)) return 0;
        if (word1 == null || word1.length() == 0) return word2.length();
        if (word2 == null || word2.length() == 0) return word1.length();

        int rows = word1.length() + 1;
        int cols = word2.length() + 1;
        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) dp[i][0] = i;
        for (int i = 0; i < cols; i++) dp[0][i] = i;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
            }
        }
        return dp[rows - 1][cols - 1];
    }
}
