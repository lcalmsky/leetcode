package io.lcalmsky.leetcode.word_break;

import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length; i++) {
            if (!dp[i]) {
                continue;
            }
            for (String word : wordDict) {
                int end = i + word.length();
                if (end > length) {
                    continue;
                }
                if (dp[end]) {
                    continue;
                }
                if (s.substring(i, end).equals(word)) {
                    dp[end] = true;
                }
            }
        }
        return dp[length];
    }
}
