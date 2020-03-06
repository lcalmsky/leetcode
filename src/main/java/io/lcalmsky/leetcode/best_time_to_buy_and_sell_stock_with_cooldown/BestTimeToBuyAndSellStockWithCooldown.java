package io.lcalmsky.leetcode.best_time_to_buy_and_sell_stock_with_cooldown;

public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy;

        for (int price : prices) {
            prevBuy = buy;
            buy = Math.max(prevSell - price, prevBuy);
            prevSell = sell;
            sell = Math.max(prevBuy + price, prevSell);
        }

        return sell;
    }
}
