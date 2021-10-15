package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_with_cooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int sell = 0, previousSell = 0, buy = Integer.MIN_VALUE, previousBuy;
        for (int price : prices) {
            previousBuy = buy;
            buy = Math.max(previousSell - price, previousBuy);
            previousSell = sell;
            sell = Math.max(previousBuy + price, previousSell);
        }
        return sell;
    }
}
