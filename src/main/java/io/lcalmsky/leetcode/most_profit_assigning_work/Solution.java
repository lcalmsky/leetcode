package io.lcalmsky.leetcode.most_profit_assigning_work;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[] maxProfit = new int[100001];
        for (int i = 0; i < difficulty.length; i++)
            maxProfit[difficulty[i]] = Math.max(maxProfit[difficulty[i]], profit[i]);
        for (int i = 2; i < maxProfit.length; i++) maxProfit[i] = Math.max(maxProfit[i], maxProfit[i - 1]);
        int result = 0;
        for (int ability : worker) result += maxProfit[ability];
        return result;
    }
}
